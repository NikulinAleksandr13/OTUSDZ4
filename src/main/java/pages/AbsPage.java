package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.Random;

public abstract class AbsPage {
    protected final WebDriver driver;
    private Random random = new Random();
    private final Actions actions;
    public AbsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clearAndSend(WebElement element, String field) {
        element.clear();
        element.sendKeys(field);
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void moveAndClick(WebElement element) {
        actions.moveToElement(element);
        element.click();
    }
    public WebElement getRandomElement(WebElement [] elements) {
        int index = random.nextInt(elements.length);
        return elements[index];
    }
}
