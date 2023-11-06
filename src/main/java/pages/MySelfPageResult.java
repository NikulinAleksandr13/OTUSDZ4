package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
@Getter
public class MySelfPageResult extends AbsBasePage {

    public MySelfPageResult(WebDriver driver) {
        super(driver);
    }

    String locator = "//p[contains(text(),'%s %s')]";

    public WebElement setLocator(String string, String string2) {
        String elementsId = String.format(this.locator, string, string2);
        WebElement element = driver.findElement(By.xpath(elementsId));
        return element;
    }

    public void assertField(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }
}
