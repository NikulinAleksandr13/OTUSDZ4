package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends AbsBasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//span[@class = 'sc-199a3eq-0 fJMWHf']")
    private WebElement nameLogin;
    @FindBy(xpath = "//a[contains(text(), 'Мой профиль')]")
    private WebElement myProfile;


        public void goToMySelf() {
            waiters.waitElementVisible(nameLogin);
            actions.moveToElement(nameLogin).build().perform();
            waiters.waitElementVisible(myProfile);
            moveAndClick(myProfile);
            new MySelfPage(driver);
        }
}
