package pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import webDriverProvider.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;

    private ConfigFileReader configFileReader;
    private WebDriverManager webDriverManager;

    public void setUp() {
        webDriverManager = new WebDriverManager();
        configFileReader = new ConfigFileReader();

        System.setProperty(configFileReader.getSysPropertyName(),
                configFileReader.getSysPropertyValue());

        driver = webDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.get(configFileReader.getUrl());
    }
}
