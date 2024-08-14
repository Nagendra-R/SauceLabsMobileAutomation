package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.FileNotFoundException;

public class Hooks {

    @Before
    public void setUp(){
        ConfigReader.initProperties();
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        DriverManager.getDriver().quit();
    }


}
