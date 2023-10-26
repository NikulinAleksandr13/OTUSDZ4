package waiters;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    public WebDriver driver;

    public Waiters(WebDriver driver){
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            webDriverWait.until(condition);
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public boolean waitElementVisible(WebElement element) {
       return waitForCondition(ExpectedConditions.visibilityOf(element));
    }
}
