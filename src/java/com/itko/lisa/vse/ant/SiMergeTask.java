package com.itko.lisa.vse.ant;

import org.apache.tools.ant.BuildException;

/**
 * Merge an SI Export with an existing image.
 * Deprecated since LISA 6.0
 * 
 * @author <a href="mailto:luther@itko.com">Luther Birdzell</a>
 */
@Deprecated
public class SiMergeTask
        extends VseTaskBase
{
    private String name;
    private String path;

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
            log("Merging SI Export from '" + path + "' with SI '" + name + "'",
                Project.MSG_INFO);

            VseServiceImageHelper.mergeServiceImageLive(name, path);
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
}
