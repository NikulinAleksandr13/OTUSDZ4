package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends AbsBasePage {

    public StartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement loginButton;

    public void signIn() {
       waiters.waitElementVisible(loginButton);
        loginButton.click();
        new LoginPage(driver);
    }

}
