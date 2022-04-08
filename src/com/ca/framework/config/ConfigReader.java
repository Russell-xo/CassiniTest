package com.ca.framework.config;

import com.ca.framework.base.BrowserType;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void PopulateSettings() throws IOException
    {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();

    }

    private void ReadProperty() throws IOException
    {
        Properties p = new Properties();
        p.load(getClass().getResourceAsStream("Config.properties"));
        //Get AUT
        Settings.AUT = p.getProperty("AUT");
        //Browser Type
        Settings.BrowserType = BrowserType.valueOf(p.getProperty("BrowserType"));
        //GEt ExcelSheetPath
        Settings.ExcelSheetPath = p.getProperty("ExcelSheetPath");

    }
}
