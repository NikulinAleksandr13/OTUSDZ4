package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;


public abstract class Helper {
    protected WebDriver driver;
    protected final Actions actions;
    protected final Faker faker;
    protected Random random;
    public Helper(WebDriver driver){
       this.driver = driver;
       this.actions = new Actions(driver);
       this.faker = new Faker();
       this.random = new Random();
    }
    public void clearAndSend(WebElement element, String field) {
        element.clear();
        element.sendKeys(field);
    }

    public void moveAndClick(WebElement element) {
        actions.moveToElement(element).build().perform();
        element.click();
    }
    public WebElement getRandomElement(WebElement [] elements) {
        int index = random.nextInt(elements.length);
        return elements[index];
    }

    public WebElement $(By by) {
        return driver.findElement(by);
    }
}
