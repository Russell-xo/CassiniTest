package com.ca.test.hooks;

import com.ca.framework.base.DriverContext;
import com.ca.framework.base.Initializer;
import com.ca.framework.config.ConfigReader;
import com.ca.framework.config.Settings;
import com.ca.framework.utilities.ExcelUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class TestInitializer extends Initializer {

    @Before
    public void Initialize() throws IOException {
        //Initialize Config
        ConfigReader.PopulateSettings();

        InitializeBrowser(Settings.BrowserType);
        DriverContext.Browser.GoToUrl(Settings.AUT);
        /*try {
            ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);
        } catch (Exception e) {
        }*/

    }

    @After
    public void TearDown() throws IOException
    {
        DriverContext.Driver.close();
    }
}
