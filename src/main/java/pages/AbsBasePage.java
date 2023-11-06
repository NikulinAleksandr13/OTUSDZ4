package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

    private final String BASE_URL = System.getProperty("base.url", "http://otus.ru/");
    private String path = "";

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private String configUrl() {
        return BASE_URL.endsWith("/") ? BASE_URL.replaceAll("/$", "") : BASE_URL;
    }

    public void openPage(String path) {
        driver.get(configUrl() + path);
    }

    String selectorId = "#id_%s";

    public WebElement setSelector(String string) {
        String elementsId = String.format(this.selectorId, string);
        WebElement element = driver.findElement(By.cssSelector(elementsId));
        return element;
    }

    String locator = "//button[contains(@title,'%s')]";

    public WebElement setLocator(String string) {
        String elementsId = String.format(this.locator, string);
        WebElement element = driver.findElement(By.xpath(elementsId));
        return element;
    }
}
