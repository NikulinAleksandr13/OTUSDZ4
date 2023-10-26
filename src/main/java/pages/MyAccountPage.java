package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;


public class MyAccountPage extends Helper {
    private Waiters waiters;
    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waiters = new Waiters(driver);
    }

    @FindBy(xpath ="//span[@class = 'sc-199a3eq-0 fJMWHf']")
    private WebElement nameLogin;
    @FindBy(xpath = "//a[contains(text(), 'Мой профиль')]")
    private WebElement myProfile;


        public MySelfPage goToMySelf() {
            waiters.waitElementVisible(nameLogin);
            moveToElement(nameLogin);
            waiters.waitElementVisible(myProfile);
            moveAndClick(myProfile);
            return new MySelfPage(driver);
        }
}
