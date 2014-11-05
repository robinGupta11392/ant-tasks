package com.itko.lisa.vse.ant;

import org.apache.tools.ant.BuildException;

/**
 * <pre>
 * Perform a 'mix in' of raw traffic xml. Existing conversations may be added to
 *             and new conversations may be added. The transport protocol must be one of:
 *                  "HTTP/S"
 *                  "JDBC"
 *                  "IBM MQ Series"
 *                  "Standard JMS"
 *                  "From WSDL for HTTP/S"
 *                  "Java"
 *             The data protocol must be one of:
 *                  "Web Services (SOAP)"
 *                  "Web Services Bridge"
 *                  "Auto Hash Transaction Discovery"
 *                  "Generic XML Payload Parser"
 *                  "HTTP Traffic (web)"
 *                  "null"
 *                  "Protocol layer for handling messages over IBM MQ."
 *                  "Protocol layer for handling messages over JMS using JNDI."
 *                  "null"
 *                  "Protocol layer for handling calls to Java classes."
 *             Note that "null" is a legitimate data protocol name to use for some transport protocols!
 *             "tol1" represents the default tolerance to use for non-leaf
 *             transactions and "tol2" represents the default tolerance to use for
 *             leaf transactions. Both must be one of CLOSE, WIDE or LOOSE.  If not
 *             specified, "tol1" will default to WIDE and "tol2" to LOOSE.
 * 
 * @param name - the name of the deployed Service Image
 * @param path - the path of the SI raw traffic file to mix with the deployed image
 * @param transportProtocol (see above)
 * @param dataProtocol (see above)
 * @param tol1 (see above)
 * @param tol2 (see above)
 * </pre>
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 */
@Deprecated
public class SiMixLiveTask
        extends VseTaskBase
{
    private String name;
    private String path;
    private String transportProtocol;
    private String dataProtocol;
    private String tol1;
    private String tol2;

    /**
     * 
     * 
     * @throws BuildException
     */
    public void execute() throws BuildException
    {
    	throw new UnsupportedOperationException("No longer supported since LISA 6.0");
		/*try
        {
            log("Mixing VS raw traffic from '" + path + "' with SI '"
                    + name + "'", Project.MSG_INFO);

            VseServiceImageHelper.mixWithServiceImage(name,
                                                      path,
                                                      transportProtocol,
                                                      new String[]{dataProtocol},
                                                      tol1,
                                                      tol2);
        }
        catch ( Exception e )
        {
            log(e.toString(), Project.MSG_ERR);
            throw new BuildException(e);
        }*/
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the path
     */
    public String getPath()
    {
        return path;
    }

    /**
     * @param path
     *            the path to set
     */
    public void setPath(String path)
    {
        this.path = path;
    }

    /**
     * @return the transportProtocol
     */
    public String getTransportProtocol()
    {
        return transportProtocol;
    }

    /**
     * @param transportProtocol
     *            the transportProtocol to set
     */
    public void setTransportProtocol(String transportProtocol)
    {
        this.transportProtocol = transportProtocol;
    }

    /**
     * @return the dataProtocol
     */
    public String getDataProtocol()
    {
        return dataProtocol;
    }

    /**
     * @param dataProtocol
     *            the dataProtocol to set
     */
    public void setDataProtocol(String dataProtocol)
    {
        this.dataProtocol = dataProtocol;
    }

    /**
     * @return the tol1
     */
    public String getTol1()
    {
        return tol1;
    }

    /**
     * @param tol1
     *            the tol1 to set
     */
    public void setTol1(String tol1)
    {
        this.tol1 = tol1;
    }

    /**
     * @return the tol2
     */
    public String getTol2()
    {
        return tol2;
    }

    /**
     * @param tol2
     *            the tol2 to set
     */
    public void setTol2(String tol2)
    {
        this.tol2 = tol2;
    }

}
