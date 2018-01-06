package com.surenpi.autotest.browser;

/**
 * @author suren
 */
public interface BrowserDetector
{
    String os();
    String browserVer(Browser browser);
    String browserMajorVer(Browser browser);
    String browserPath(Browser browser);
}
