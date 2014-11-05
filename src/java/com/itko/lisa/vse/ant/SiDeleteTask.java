package com.itko.lisa.vse.ant;

import org.apache.tools.ant.BuildException;

/**
 * Deprecated in LISA 6.0
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 * @author <a href="mailto:vamsi.kurukuri@itko.com">Vamsi Kurukuri</a>
 */
@Deprecated
public class SiDeleteTask extends VseTaskBase {
	private String name;

	private String servicesDirPath;

	/**
	 * 
	 * 
	 * @throws BuildException
	 */
	public void execute() throws BuildException {
		throw new UnsupportedOperationException("No longer supported since LISA 6.0");
		/*try { 
			if (Boolean.parseBoolean(all)) { 
				if(VseServiceImageHelper.EXECUTION_LEVEL_PROJECT.equals(getExecutionLevel())) {
					log("Executing : Delete Task, serviceDirPath = "
							+ servicesDirPath + ", all = " + all
							+ ", executionLevel = " + executionLevel,
							Project.MSG_INFO);
				} else {
					log("Executing : Delete Task, all = " + all
							+ ", executionLevel = " + executionLevel,
							Project.MSG_INFO);
				}

				VseServiceImageHelper.deleteAllServiceImages(
						this.servicesDirPath, lisaRegistry, vseName,
						getExecutionLevel());
			} else {
				log("Executing : Delete Task, name = " + name,
						Project.MSG_INFO);
				VseServiceImageHelper.deleteServiceImage(name);
			}
		} catch (Exception e) {
			log(e.toString(), Project.MSG_ERR);
			throw new BuildException(e);
		}*/
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getServicesDirPath() {
		return servicesDirPath;
	}

	public void setServicesDirPath(String servicesDirPath) {
		this.servicesDirPath = servicesDirPath;
	}
}
