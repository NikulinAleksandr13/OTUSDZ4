package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbsBasePage {
    private final String LOGIN = System.getProperty("login");
    private final String PASSWORD = System.getProperty("password");
        public LoginPage(WebDriver driver) {
            super(driver);
    }

    @FindBy(xpath = "//input[@name ='email']")
    private WebElement userName;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement userPassword;
    @FindBy(css = ".sc-9a4spb-0.gYNtqF.sc-11ptd2v-2-Component.cElCrZ")
    private WebElement submitLogin;

    public void login() {
        this.userName.sendKeys(LOGIN);
        userPassword.sendKeys(PASSWORD);
        submitLogin.click();
        new MyAccountPage(driver);
    }
}
