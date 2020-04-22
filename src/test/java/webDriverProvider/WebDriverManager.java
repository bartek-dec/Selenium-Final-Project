package webDriverProvider;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManager {

    private WebDriver driver;

    private ConfigFileReader configFileReader;

    public WebDriverManager() {
        configFileReader = new ConfigFileReader();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }

    private void createWebDriver() {
        String browser = configFileReader.getBrowser();

        if (browser == null) {
            browser = "chrome";
        }

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "ie":
                driver = new InternetExplorerDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                driver = new ChromeDriver();
                break;
        }
    }
}
