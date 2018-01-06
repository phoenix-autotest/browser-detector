package com.surenpi.autotest.browser;

import org.junit.Test;

/**
 * @author suren
 */
public class UbuntuBrowserDetectorTest
{
    @Test
    public void test()
    {
        BrowserDetector detector = new UbuntuBrowserDetector();

        String ver = detector.browserVer(Browser.CHROME);
        System.out.println(ver);

        String majorVer = detector.browserMajorVer(Browser.CHROME);
        System.out.println(majorVer);
    }
}