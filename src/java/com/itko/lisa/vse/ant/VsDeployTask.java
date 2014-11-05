package com.itko.lisa.vse.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

import com.itko.lisa.coordinator.VirtualService;
import com.itko.lisa.ext.util.TestCaseHelper;
import com.itko.lisa.ext.util.VseHelper;
import com.itko.lisa.model.mar.ModelArchive;

/**
 * Deploy a service to the VSE.
 * January 16, 2014 - Updated for LISA VSE 7.x
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 * @author <a href="mailto:vamsi.kurukuri@itko.com">Vamsi Kurukuri</a>
 * @author <a href="mailto:steve.roberts@ca.com">Steve Roberts</a>
 * @TODO Think time and Threads capabilities should be implemented on this
 *       deployment task.
 */
public class VsDeployTask extends VseTaskBase {

	private String configFilePath;

	private String autoStart = "false";
	
	private String autoRestart = "true";
	
	private String deployedVsName;

	private String vsmFilepath;

	private String servicesDirPath;

	private String skipIfDeployed = "true";

	/**
	 * 
	 * 
	 * @throws BuildException
	 */
	public void execute() throws BuildException {
		try {
			VseHelper vseh;
			try {
				vseh = VseHelper.getInstance(vseName);
			} catch(Throwable t) {
				t.printStackTrace(System.err);
				throw new BuildException(t);
			}
			log("Environment: Deploy Task" +
					", lisahome = " + lisahome +
					", lisaRegistry = " + lisaRegistry +
					", vseName = " + vseName,
					Project.MSG_INFO);
			if (Boolean.parseBoolean(all)) {
				if (servicesDirPath == null) {
					throw new BuildException(
							"Deploy Task : If attribute all=true , serviceDirPath is mandarory.");
				}
				log("Executing: Deploy Task" +
						", all = " + all +
						", serviceDirPath = " + servicesDirPath,
						Project.MSG_INFO);
				vseh.deployAllServices(servicesDirPath);
			} else {
				if (vsmFilepath == null) {
					throw new BuildException(
							"Deploy Task : If attribute all=false , vsmFilepath is mandarory.");
				}
				log("Executing: Deploy Task" +
						", all = " + all +
						", vsmFilepath = " + vsmFilepath +
						", configFilePath = " + configFilePath + 
						", autoStart = " + autoStart +
						", autoRestart = " + autoRestart +
						", skipIfDeployed = " + skipIfDeployed,
						Project.MSG_INFO);
				ModelArchive mar = TestCaseHelper.buildMarForVSM( vsmFilepath, configFilePath, 1, 100, Boolean.parseBoolean(autoRestart) );
				deployedVsName = mar.getMARInfo().getName();
				
				// If service is already deployed then either skip or redeploy
				if(vseh.getDeployedModelNames().contains(deployedVsName)) {
					if(! Boolean.parseBoolean(skipIfDeployed)) {
						vseh.redeployModel(mar);
					}
				} else {
					vseh.deployService(mar);
				}
				
				// Start the service if autoStart is set
				if(Boolean.parseBoolean(autoStart) && vseh.getServiceStatus(deployedVsName) != VirtualService.STATUS_RUNNING) {
					vseh.startService(deployedVsName);
				}
			}

		} catch (Exception e) {
			log(e.toString(), Project.MSG_ERR);
			throw new BuildException(e);
		}
	}
	
	public String getVsmFilepath() {
		return vsmFilepath;
	}

	public void setVsmFilepath(String vsmFilepath) {
		this.vsmFilepath = vsmFilepath;
	}

	public String getSkipIfDeployed() {
		return skipIfDeployed;
	}

	public void setSkipIfDeployed(String skipIfDeployed) {
		this.skipIfDeployed = skipIfDeployed;
	}

	public String getServicesDirPath() {
		return servicesDirPath;
	}

	public void setServicesDirPath(String servicesDirPath) {
		this.servicesDirPath = servicesDirPath;
	}

	public String getConfigFilePath() {
		return configFilePath;
	}

	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
	}

	public String getAutoRestart() {
		return autoRestart;
	}

	public void setAutoRestart(String autoRestart) {
		this.autoRestart = autoRestart;
	}
	
	public String getDeployedName() {
		return deployedVsName;
	}
}
