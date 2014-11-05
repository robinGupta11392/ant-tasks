package com.itko.lisa.vse.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

import com.itko.lisa.ext.util.VseHelper;

/**
 * Stop a running virtual service.
 * January 16, 2014 - Updated for LISA VSE 7.x
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 * @author <a href="mailto:steve.roberts@ca.com">Steve Roberts</a>
 */
public class VsStopTask extends VseTaskBase
{
    private String name;
    
    /**
     * 
     * 
     * @throws BuildException
     */
    public void execute() throws BuildException
    {
        try
        {
        	VseHelper vseh;
        	try {
        		vseh = VseHelper.getInstance(vseName);
        	} catch(Throwable t) {
        		t.printStackTrace(System.err);
        		throw new BuildException(t);
        	}
        	log("Environment: Stop Task" +
					", lisahome = " + lisahome +
					", lisaRegistry = " + lisaRegistry +
					", vseName = " + vseName,
					Project.MSG_INFO);
        	if (Boolean.parseBoolean(all)) {
        		log("Executing: Stop Task" +
        				", all = " + all,
    					Project.MSG_INFO);
				vseh.stopAllServices();
			} else {
				log("Executing: Stop Task" +
        				", all = " + all +
        				", name = " + name,
    					Project.MSG_INFO);
				vseh.stopService(name);
			}
        }
        catch ( Exception e )
        {
            log(e.toString(), Project.MSG_ERR);
            throw new BuildException(e);
        }
    }

    /**
     * @return the name of the service
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name of the service
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
