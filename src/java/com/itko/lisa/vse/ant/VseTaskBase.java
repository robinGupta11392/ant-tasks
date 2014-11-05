package com.itko.lisa.vse.ant;

import org.apache.tools.ant.Task;

import com.itko.lisa.net.NetConstants;

/**
 * Abstract base class for LISA VSE Ant tasks.
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 * @author <a href="mailto:vamsi.kurukuri@itko.com">Vamsi Kurukuri</a>
 * @author <a href="mailto:steve.roberts@ca.com">Steve Roberts</a>
 */
abstract class VseTaskBase extends Task {

	protected String all;

	protected String lisahome;

	protected String lisaRegistry;

	protected String vseName;

	protected String executionLevel = EXECUTION_LEVEL_VSE;
	
	public static final String EXECUTION_LEVEL_PROJECT = "project";
	public static final String EXECUTION_LEVEL_VSE = "vse";

	/**
	 * Return ant tasks execution level.
	 * 
	 * @return ant tasks execution level.
	 */
	public String getExecutionLevel() {
		return executionLevel;
	}

	/**
	 * The Ant tasks can be executed either on project level or vse level. This
	 * is an optional field, if this is not specified by default ant tasks will
	 * execute on vse level.
	 * 
	 * @param executionLevel
	 */
	public void setExecutionLevel(String executionLevel) {
		this.executionLevel = executionLevel;
	}

	/**
	 * Return remote registry url or local registry names.
	 * 
	 * @return remote registry url or local registry names.
	 */
	public String getLisaRegistry() {
		return lisaRegistry;
	}

	/**
	 * The ant tasks can execute on remote registry or local registry name. This
	 * is an optional field, user can either specify remote registry url or
	 * local registry names. If lisa registry is not specified by default the
	 * ant tasks execute on default registry.
	 * 
	 * @param lisaRegistry
	 *            field can take remote registry url or local registry names.
	 */
	public void setLisaRegistry(String lisaRegistry) {
		this.lisaRegistry = lisaRegistry;
		NetConstants.setRegistryUrl(lisaRegistry);
	}

	public String getVseName() {
		return vseName;
	}

	/**
	 * The ant tasks can execute on remote registry. This is an optional field,
	 * user can specify vse server name. If vse name is not specified the
	 * default vse name will be picked. (lisa.VSEServer)
	 * 
	 * @param vseName
	 *            field can take vse server name.
	 */
	public void setVseName(String vseName) {
		this.vseName = vseName;
	}

	/**
	 * @return the all
	 */
	public String getAll() {
		return all;
	}

	/**
	 * @param all
	 *            the all to set
	 */
	public void setAll(String all) {
		this.all = all;
	}

	/**
	 * @return the lisahome
	 */
	public String getLisahome() {
		return lisahome;
	}

	/**
	 * @param lisahome
	 *            the lisahome to set
	 */
	public void setLisahome(String lisahome) {
		this.lisahome = lisahome;
		// required to instantiate the VirtualServiceEnvironment object
		System.setProperty("LISA_HOME", lisahome);
	}

}
