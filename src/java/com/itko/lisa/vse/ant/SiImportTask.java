package com.itko.lisa.vse.ant;

import org.apache.tools.ant.BuildException;

/**
 * Deprecated in LISA 6.0
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 * @author <a href="mailto:vamsi.kurukuri@itko.com">Vamsi Kurukuri</a>
 */
@Deprecated
public class SiImportTask extends VseTaskBase {

	private String imageFilePath;

	private String imagesDirPath;

	private String servicesDirPath;

	private String force;

	/**
	 * 
	 * 
	 * @throws BuildException
	 */
	public void execute() throws BuildException {
		throw new UnsupportedOperationException("No longer supported since LISA 6.0");
		/*try {
			if (Boolean.parseBoolean(all)) {
				if (VseServiceImageHelper.EXECUTION_LEVEL_PROJECT.equals(this.executionLevel)) {
					// Validating
					if (getImagesDirPath() == null) {
						throw new BuildException(
								"Import Task : If atributes all=true , executionLevel=project, imagesDirPath is mandarory.");
					}

					if (getServicesDirPath() == null) {
						throw new BuildException(
								"Import Task : If atributes all=true , executionLevel=project, serviceDirPath is mandarory.");
					}

					log("Executing: Import Task, imagesDirPath = "
							+ getImagesDirPath() + ", serviceDirPath = "
							+ servicesDirPath + ", all = " + all
							+ ", executionLevel = " + executionLevel,
							Project.MSG_INFO);
					// Executing
					VseServiceImageHelper.importAllServiceImages(
							getImagesDirPath(), getServicesDirPath(), getLisaRegistry(),
							getVseName(), Boolean.parseBoolean(getForce()),
							"project");
				} else {

					// Validating
					if (getImagesDirPath() == null) {
						throw new BuildException(
								"Import Task : If atributes all=true , executionLevel=project, imagesDirPath is mandarory.");
					}

					log("Executing: Import Task, imagesDirPath = "
							+ getImagesDirPath() + ", all = " + all
							+ ", executionLevel = " + executionLevel,
							Project.MSG_INFO);

					// Executing
					VseServiceImageHelper.importAllServiceImages(
							getImagesDirPath(), null, getLisaRegistry(),
							getVseName(), Boolean.parseBoolean(getForce()),
							"vse");
				}

			} else {
				log("Executing: Import Task, imageFilePath = "
						+ getImageFilePath(), Project.MSG_INFO);
				VseServiceImageHelper.importServiceImage(getImageFilePath());
			}
		} catch (Exception e) {
			log(e.toString(), Project.MSG_ERR);
			throw new BuildException(e);
		}*/
	}

	public String getServicesDirPath() {
		return servicesDirPath;
	}

	public void setServicesDirPath(String serviceDirPath) {
		this.servicesDirPath = serviceDirPath;
	}

	public String getImagesDirPath() {
		return imagesDirPath;
	}

	public void setImagesDirPath(String imagesDirPath) {
		this.imagesDirPath = imagesDirPath;
	}

	public String getForce() {
		return force;
	}

	public void setForce(String force) {
		this.force = force;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
}
