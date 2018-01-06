package com.surenpi.autotest.browser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author suren
 */
public class UbuntuBrowserDetector implements BrowserDetector
{
    public String os()
    {
        return "linux";
    }

    public String browserVer(Browser browser)
    {
        try
        {
            Process process = Runtime.getRuntime().exec("chromium-browser --version");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = null;
            while((line = reader.readLine()) != null)
            {
                if(line.startsWith("Chromium"))
                {
                    String[] rawArray = line.split(" ", 3);
                    if(rawArray.length > 2)
                    {
                        return rawArray[1];
                    }

                    break;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public String browserMajorVer(Browser browser)
    {
        String version = browserVer(browser);
        if(version != null && version.indexOf(".") != -1)
        {
            return version.split("\\.")[0];
        }

        return null;
    }

    public String browserPath(Browser browser)
    {
        return null;
    }
}