package com.itko.lisa.vse.ant.test;

import junit.framework.TestCase;

/**
 * JUnit test for LISA VSE Ant tasks.
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 */
@Deprecated
public class VseAntTest extends TestCase {
	/*
	private static Logger logger = Logger.getLogger(VseAntTest.class.getName());

	private static String lisaHome = "/Users/vamsikurukuri/itko/lisa/server/5.0.27";

	private static String imagesDirPath = "test-data/vse-project/VServices/Images";

	private static String servicesDirPath = "test-data/vse-project/VServices";

	private static String configFilePath = "test-data/vse-project/Configs/project.config";

	private static String lisaRegistry = "rmi://localhost/lisa.Registry";

	private static String vseName = "lisa.VSEServer";

	private static String siImportPath = "test-data/si-import";

	private static String siExportPath = "test-data/si-export";

	// import our test SIs
	public void testImportSiVSELevel() {
		try {
			SiImportTask task = new SiImportTask();
			task.setLisahome(lisaHome);
			task.setAll("true");
			task.setImagesDirPath(imagesDirPath);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setForce("true");
			task.execute();

			// List < String > siNames =
			// VseServiceImageHelper.getServiceImageNames();
			// assertTrue(siNames.contains("list-users"));
			// assertTrue(siNames.contains("UserControl"));
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	// export all of the SIs first
	public void testExportSiVSELevel() {
		try {
			// cleanup from prior runs
			File siExportPathDir = new File(imagesDirPath);
			siExportPathDir.delete();

			SiExportTask task = new SiExportTask();
			task.setLisahome(lisaHome);
			task.setAll("true");
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setImagesDirPath(imagesDirPath);
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	// Deploy VSM"S
	public void testDeployALlVsmodelsVSELevel() {
		try {
			VsDeployTask task = new VsDeployTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setServicesDirPath(servicesDirPath);
			task.setConfigFilePath(configFilePath);
			task.setAutoRestart("true");
			task.setAll("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	public void testStartVsVSELevel() {
		try {
			VsStartTask task = new VsStartTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	public void testStopVsVSELevel() {
		try {
			VsStopTask task = new VsStopTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	public void testRemoveVsVSELevel() {
		try {
			VsRemoveTask task = new VsRemoveTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setServicesDirPath(servicesDirPath);
			task.setAll("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	public void testDeployALlVsmodelsProjectLevel() {
		try {
			VsDeployTask task = new VsDeployTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setServicesDirPath(servicesDirPath);
			task.setConfigFilePath(configFilePath);
			task.setAutoRestart("true");
			task.setAll("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	public void testStartVsProjectLevel() {
		try {
			VsStartTask task = new VsStartTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("true");
			task.setServicesDirPath(servicesDirPath);
			task.setExecutionLevel(VseServiceImageHelper.EXECUTION_LEVEL_PROJECT);
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	public void testStopVsProjectLevel() {
		try {
			VsStopTask task = new VsStopTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("true");
			task.setServicesDirPath(servicesDirPath);
			task.setExecutionLevel(VseServiceImageHelper.EXECUTION_LEVEL_PROJECT);
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	public void testRemoveVsProjectLevel() {
		try {
			VsRemoveTask task = new VsRemoveTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setServicesDirPath(servicesDirPath);
			task.setExecutionLevel(VseServiceImageHelper.EXECUTION_LEVEL_PROJECT);
			task.setAll("true");
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	// delete our SIs
	public void testDeleteSiVSELevel() {
		try {
			SiDeleteTask task = new SiDeleteTask();
			task.setLisahome(lisaHome);
			task.setAll("true");
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.execute();

			// List < String > siNames =
			// VseServiceImageHelper.getServiceImageNames();
			// assertTrue(siNames.size() == 0);
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	// import our test SIs
	public void testImportSiProjectLevel() {
		try {
			SiImportTask task = new SiImportTask();
			task.setLisahome(lisaHome);
			task.setAll("true");
			task.setImagesDirPath(imagesDirPath);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setForce("true");
			task.setServicesDirPath(servicesDirPath);
			task.setExecutionLevel(VseServiceImageHelper.EXECUTION_LEVEL_PROJECT);
			task.execute();

			// List < String > siNames =
			// VseServiceImageHelper.getServiceImageNames();
			// assertTrue(siNames.contains("list-users"));
			// assertTrue(siNames.contains("UserControl"));
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	// export all of the SIs first
	public void testExportSiProjectLevel() {
		try {
			// cleanup from prior runs
			File siExportPathDir = new File(imagesDirPath);
			siExportPathDir.delete();

			SiExportTask task = new SiExportTask();
			task.setLisahome(lisaHome);
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setAll("true");
			task.setImagesDirPath(imagesDirPath);
			task.setServicesDirPath(servicesDirPath);
			task.setExecutionLevel(VseServiceImageHelper.EXECUTION_LEVEL_PROJECT);
			task.execute();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}

	// delete our SIs
	public void testDeleteSiProjectLevel() {
		try {
			SiDeleteTask task = new SiDeleteTask();
			task.setLisahome(lisaHome);
			task.setAll("true");
			task.setLisaRegistry(lisaRegistry);
			task.setVseName(vseName);
			task.setServicesDirPath(servicesDirPath);
			task.setExecutionLevel(VseServiceImageHelper.EXECUTION_LEVEL_PROJECT);
			task.execute();

			// List < String > siNames =
			// VseServiceImageHelper.getServiceImageNames();
			// assertTrue(siNames.size() == 0);
		} catch (Throwable t) {
			logger.log(Level.SEVERE, t.getMessage(), t);
			fail(t.getMessage());
		}
	}
	*/

	// /**
	// *
	// *
	// */
	// public void testMixVs() {
	// try {
	// SiMixTask task = new SiMixTask();
	// task.setLisahome(lisaHome);
	// task.setName("UserControl");
	// task.setPath("/Users/looth/main/vse-ant-tasks/test-data/list-users-raw-traffic.xml");
	// task.setTransportProtocol("HTTP/S");
	// task.setDataProtocol("Web Services (SOAP)");
	// task.setTol1("WIDE");
	// task.setTol2("LOOSE");
	// // task.execute();
	// } catch (Throwable t) {
	// logger.log(Level.SEVERE, t.getMessage(), t);
	// fail(t.getMessage());
	// }
	// }
	//
	// public void testMixVsLive() {
	// try {
	// // SiMixLiveTask task = new SiMixLiveTask();
	// // task.setLisahome(lisaHome);
	// // task.setSourceName("UserControl");
	// // task.setTargetName("list-users");
	// // task.setTransportProtocol("HTTP/S");
	// // task.setDataProtocol("Web Services (SOAP)");
	// // task.setTol1("WIDE");
	// // task.setTol2("LOOSE");
	// // task.execute();
	// } catch (Throwable t) {
	// logger.log(Level.SEVERE, t.getMessage(), t);
	// fail(t.getMessage());
	// }
	// }
	//
	// /**
	// *
	// *
	// */
	// public void testMergeVs() {
	// try {
	// SiMergeTask task = new SiMergeTask();
	// task.setLisahome(lisaHome);
	// task.setName("list-users");
	// task.setPath("UserControl");
	// task.execute();
	// } catch (Throwable t) {
	// logger.log(Level.SEVERE, t.getMessage(), t);
	// fail(t.getMessage());
	// }
	// }
	//
	// public void testDeployVs() {
	// try {
	// VsDeployTask task = new VsDeployTask();
	// task.setLisahome(lisaHome);
	// task.setAll("true");
	// // task.execute();
	// } catch (Throwable t) {
	// logger.log(Level.SEVERE, t.getMessage(), t);
	// fail(t.getMessage());
	// }
	// }
	//
	// public void testStartVs() {
	// try {
	// VsStartTask task = new VsStartTask();
	// task.setLisahome(lisaHome);
	// task.setAll("true");
	// // task.execute();
	// } catch (Throwable t) {
	// logger.log(Level.SEVERE, t.getMessage(), t);
	// fail(t.getMessage());
	// }
	// }
	//
	// public void testStopVs() {
	// try {
	// VsStopTask task = new VsStopTask();
	// task.setLisahome(lisaHome);
	// task.setAll("true");
	// // task.execute();
	// } catch (Throwable t) {
	// logger.log(Level.SEVERE, t.getMessage(), t);
	// fail(t.getMessage());
	// }
	// }
	//
	// public void testRemoveVs() {
	// try {
	// VsRemoveTask task = new VsRemoveTask();
	// task.setLisahome(lisaHome);
	// task.setAll("true");
	// // task.execute();
	// } catch (Throwable t) {
	// logger.log(Level.SEVERE, t.getMessage(), t);
	// fail(t.getMessage());
	// }
	// }
	//
	// // replace the SIs that were there when we started
	// public void testImportOriginalSi() {
	// try {
	// SiImportTask task = new SiImportTask();
	// task.setLisahome(lisaHome);
	// task.setAll("true");
	// task.setImagesDirPath(imagesDirPath);
	// // task.execute();
	// } catch (Throwable t) {
	// logger.log(Level.SEVERE, t.getMessage(), t);
	// fail(t.getMessage());
	// }
	// }
}
