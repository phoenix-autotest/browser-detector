package com.surenpi.autotest.browser;

/**
 * @author suren
 */
public interface BrowserDetector
{
    String os();
    String browserVer(Browser browser);
    default String browserMajorVer(Browser browser)
    {
        String version = browserVer(browser);
        if(version != null && version.indexOf(".") != -1)
        {
            return version.split("\\.")[0];
        }

        return null;
    }

    String browserPath(Browser browser);
}
