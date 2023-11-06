package factory;

import factory.drivers.ChromeWebDriver;
import factory.drivers.FirefoxWebDriver;
import factory.drivers.nameData.BrowserNameData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class WebDriverFactory implements IDriverFactory {
    public WebDriver getDriver (BrowserNameData browserNameData) {
        switch (browserNameData) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                return new ChromeWebDriver().newDriver();
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxWebDriver().newDriver();
            }
        }
        return null;
    }

    public WebDriver getDriverOneOption(BrowserNameData browserNameData, String options) {
        switch (browserNameData) {
            case CHROME: {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(options);
                return new ChromeDriver(chromeOptions);
            }
            case FIREFOX: {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(options);
                return new FirefoxDriver(firefoxOptions);
            }
        }
        return null;
    }
}
