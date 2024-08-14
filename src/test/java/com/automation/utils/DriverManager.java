package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static AppiumDriver driver;

    public static void createDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName",ConfigReader.getConfigValue("platform.name"));
        desiredCapabilities.setCapability("deviceName",ConfigReader.getConfigValue("device.name"));
        desiredCapabilities.setCapability("automationName",ConfigReader.getConfigValue("automation.name"));
        desiredCapabilities.setCapability("app",ConfigReader.getConfigValue("sauce.app"));
        desiredCapabilities.setCapability("appPackage",ConfigReader.getConfigValue("app.package"));
        desiredCapabilities.setCapability("appActivity",ConfigReader.getConfigValue("app.activity"));

        driver = new AndroidDriver(desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    public static AppiumDriver getDriver(){
        return driver;
    }


}
