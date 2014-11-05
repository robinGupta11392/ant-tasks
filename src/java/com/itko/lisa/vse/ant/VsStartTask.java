package com.itko.lisa.vse.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

import com.itko.lisa.coordinator.VirtualService;
import com.itko.lisa.ext.util.VseHelper;

/**
 * Start an already deployed virtual service.
 * January 16, 2014 - Updated for LISA VSE 7.x
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 * @author <a href="mailto:steve.roberts@ca.com">Steve Roberts</a>
 */
public class VsStartTask extends VseTaskBase {
	private String name;
	
	private String restart = "false";

	/**
	 * 
	 * 
	 * @throws BuildException
	 */
	public void execute() throws BuildException {
		try {
			VseHelper vseh = VseHelper.getInstance(vseName);
			log("Environment: Start Task" +
					", lisahome = " + lisahome +
					", lisaRegistry = " + lisaRegistry +
					", vseName = " + vseName,
					Project.MSG_INFO);
			if (Boolean.parseBoolean(all)) {
				log("Executing: Start Task" +
						", all = " + all,
						Project.MSG_INFO);
				vseh.startAllServices();
			} else {
				log("Executing: Start Task" +
						", all = " + all +
						", name = " + name +
						", restart = " + restart,
						Project.MSG_INFO);
				
				if(vseh.getServiceStatus(name) == VirtualService.STATUS_RUNNING) {
					if(Boolean.parseBoolean(restart)) {
						vseh.stopService(name);
						
						// Wait for service to end, but don't wait more than 5 seconds
						for(int w = 0; (w < 20) && (vseh.getServiceStatus(name) != VirtualService.STATUS_ENDED); w ++) {
							Thread.sleep(250);
						}
						
						vseh.startService(name);
					}
				} else {
					vseh.startService(name);
				}
			}
		} catch (Exception e) {
			log(e.toString(), Project.MSG_ERR);
			throw new BuildException(e);
		}
	}

	/**
	 * @return the name of the service 
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name of the service
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return whether to restart the service if already running
	 */
	public String getRestart() {
		return restart;
	}
	
	/**
	 * @param restart whether to restart the service if already running
	 */
	public void setRestart(String restart) {
		this.restart = restart;
	}
}
