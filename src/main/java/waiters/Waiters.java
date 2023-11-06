package waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    private WebDriver driver;

    public Waiters(WebDriver driver){
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(condition);
            return true;
        } catch (TimeoutException ignored) {
            return false;
        }
    }

    public boolean waitElementVisible(WebElement element) {
       return waitForCondition(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitElementNotVisible(WebElement element) {
        return waitForCondition(ExpectedConditions.invisibilityOf(element));
    }

    public boolean modalElementVisible(By by) {
        return waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean modalElementNotVisible(By by) {
        return waitForCondition(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
