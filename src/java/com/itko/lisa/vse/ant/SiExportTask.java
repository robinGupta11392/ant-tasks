package com.itko.lisa.vse.ant;

import org.apache.tools.ant.BuildException;

/**
 * Deprecated in LISA 6.0
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 * @author <a href="mailto:vamsi.kurukuri@itko.com">Vamsi Kurukuri</a>
 */
@Deprecated
public class SiExportTask extends VseTaskBase {

	private String imagesDirPath;

	private String servicesDirPath;

	private String name;

	private String verbose;

	private String raw;

	/**
	 * 
	 * 
	 * @throws BuildException
	 */
	public void execute() throws BuildException {
		throw new UnsupportedOperationException("No longer supported since LISA 6.0");
		/*try {
			if (Boolean.parseBoolean(all)) {
				if (VseServiceImageHelper.EXECUTION_LEVEL_PROJECT
						.equals(this.executionLevel)) {
					// Validating
					if (getImagesDirPath() == null) {
						throw new BuildException(
								"Export Task : If atributes all=true , executionLevel=project, imagesDirPath is mandarory.");
					}

					if (getServicesDirPath() == null) {
						throw new BuildException(
								"Export Task : If atributes all=true , executionLevel=project, serviceDirPath is mandarory.");
					}

					log("Executing: Export Task, imagesDirPath = "
							+ getImagesDirPath() + ", serviceDirPath = "
							+ servicesDirPath + ", all = " + all
							+ ", executionLevel = " + executionLevel,
							Project.MSG_INFO);
					VseServiceImageHelper.exportAllServiceImages(imagesDirPath,servicesDirPath,lisaRegistry,vseName,executionLevel);
				} else {
					// Validating
					if (getImagesDirPath() == null) {
						throw new BuildException(
								"Export Task : If atributes all=true , executionLevel=project, imagesDirPath is mandarory.");
					}

					log("Executing: Export Task, imagesDirPath = "
							+ getImagesDirPath() + ", all = " + all
							+ ", executionLevel = " + executionLevel,
							Project.MSG_INFO);
					VseServiceImageHelper.exportAllServiceImages(imagesDirPath);
				}
			} else {
				log("Executing: Export Task, imagesDirPath = "
						+ getImagesDirPath() + ", raw = " + raw
						+ ", verbose = " + verbose,
						Project.MSG_INFO);
				VseServiceImageHelper.exportServiceImage(name, imagesDirPath,
						Boolean.parseBoolean(raw),
						Boolean.parseBoolean(verbose));
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

	/**
	 * @return the verbose
	 */
	public String getVerbose() {
		return verbose;
	}

	/**
	 * @param verbose
	 *            the verbose to set
	 */
	public void setVerbose(String verbose) {
		this.verbose = verbose;
	}

	/**
	 * @return the raw
	 */
	public String getRaw() {
		return raw;
	}

	/**
	 * @param raw
	 *            the raw to set
	 */
	public void setRaw(String raw) {
		this.raw = raw;
	}

	public String getImagesDirPath() {
		return imagesDirPath;
	}

	public void setImagesDirPath(String imagesDirPath) {
		this.imagesDirPath = imagesDirPath;
	}

	public String getServicesDirPath() {
		return servicesDirPath;
	}

	public void setServicesDirPath(String servicesDirPath) {
		this.servicesDirPath = servicesDirPath;
	}
}
