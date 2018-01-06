package com.surenpi.autotest.browser;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author suren
 */
public class WindowBrowserDetector implements BrowserDetector
{
    public String os()
    {
        return null;
    }

    public String browserVer(Browser browser)
    {
        String chromePath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        File chromeFile = new File(chromePath);
        if(chromeFile.isFile() && chromeFile.canExecute())
        {
            File[] versionArray = chromeFile.getParentFile().listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    try {
                        Float.parseFloat(name);
                    } catch (NumberFormatException e) {
                        if (e.getMessage().equals("multiple points")) {
                            return true;
                        }
                    }

                    return false;
                }
            });

            if(versionArray != null &&versionArray.length > 0)
            {
                return versionArray[0].getName();
            }
        }

        return null;
    }

    public String browserPath(Browser browser)
    {
        return null;
    }
}