package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;

public class LoginPage extends AbsPage {
    Waiters waiters;
    private final String LOGIN = System.getProperty("login");
    private final String PASSWORD = System.getProperty("password");
        public LoginPage(WebDriver driver) {
            super(driver);
            this.waiters = new Waiters(driver);
            PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".sc-mrx253-0.enxKCy.sc-945rct-0.iOoJwQ")
    private WebElement loginButton;
    @FindBy(css = "input[name=\"email\"]")
    private WebElement userName;
    @FindBy(css = "input[type=\"password\"]")
    private WebElement userPassword;
    @FindBy(css = ".sc-9a4spb-0.gYNtqF.sc-11ptd2v-2-Component.cElCrZ")
    private WebElement submitLogin;

    public MyAccountPage login() {
        waiters.waitElementVisible(loginButton);
        clickElement(loginButton);
        userName.sendKeys(LOGIN);
        userPassword.sendKeys(PASSWORD);
        clickElement(submitLogin);
        return new MyAccountPage(driver);
    }
}
