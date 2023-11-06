package factory;

import factory.drivers.nameData.BrowserNameData;
import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
    WebDriver getDriver(BrowserNameData browserNameData);
}
