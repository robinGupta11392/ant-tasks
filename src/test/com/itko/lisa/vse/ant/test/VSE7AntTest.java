package com.itko.lisa.vse.ant.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.itko.lisa.vse.ant.VsDeployTask;
import com.itko.lisa.vse.ant.VsRemoveTask;
import com.itko.lisa.vse.ant.VsStartTask;
import com.itko.lisa.vse.ant.VsStopTask;

public class VSE7AntTest
{
	private static Logger logger = Logger.getLogger(VSE7AntTest.class.getName());
	
	private static String lisaHome = "C:/Lisa";

	private static String servicesDirPath = lisaHome + "/examples/VServices";

	private static String configFilePath = lisaHome + "/Configs/project.config";

	private static String lisaRegistry = "tcp://localhost:2010/Registry";

	private static String vseName = "VSE";
	
	@Test
	public void testStartAndStopAll() throws Throwable {
		
		try {
			VsStartTask task = new VsStartTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
		try {
			VsStopTask task = new VsStopTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
	}
	
	public void testStartAndStopService() throws Throwable {
		
		try {
			VsStartTask task = new VsStartTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setName("setalarm");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
		try {
			VsStopTask task = new VsStopTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setName("setalarm");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
	}
	
	@Test
	public void testRestartService() throws Throwable {
		
		try {
			VsStartTask task = new VsStartTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setName("setalarm");
			task.setRestart("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
	}
	
	@Test 
	public void testDeployAndRemoveService() throws Throwable {
		
		try {
			VsDeployTask task = new VsDeployTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setConfigFilePath(configFilePath);
			task.setVsmFilepath(servicesDirPath + "/kioskV6.vsm");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
	
		try {
			VsRemoveTask task = new VsRemoveTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setName("kioskV6");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
	}
	
	@Test 
	public void testRedeployService() throws Throwable {
		
		try {
			VsDeployTask task = new VsDeployTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setConfigFilePath(configFilePath);
			task.setVsmFilepath(servicesDirPath + "/kioskV6.vsm");
			task.setSkipIfDeployed("false");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
		try {
			VsDeployTask task = new VsDeployTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setConfigFilePath(configFilePath);
			task.setVsmFilepath(servicesDirPath + "/kioskV6.vsm");
			task.setSkipIfDeployed("false");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
	}
	
	//@Test
	public void testDeployAndStartService() throws Throwable {
		
		String name;
		
		try {
			VsDeployTask task = new VsDeployTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setConfigFilePath(configFilePath);
			task.setVsmFilepath(servicesDirPath + "/kioskV6.vsm");
			task.execute();
			
			name = task.getDeployedName();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
		
		try {
			VsStartTask task = new VsStartTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("false");
			task.setName(name);
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			throw t;
		}
	}

}
