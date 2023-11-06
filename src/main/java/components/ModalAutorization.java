package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObject.AbsPageObject;

public class ModalAutorization extends AbsPageObject implements IModal {


    public ModalAutorization(WebDriver driver) {
        super(driver);
    }

    private String popupSelector = "#__PORTAL__ >div" ;

    @Override
    public void modalPresent() {
        Assert.assertTrue(waiters.modalElementVisible(By.cssSelector(popupSelector)), "Попап отображается");
    }

    @Override
    public void modalNotPresent() {
        Assert.assertTrue(waiters.modalElementNotVisible(By.cssSelector(popupSelector)), "Попап не отображается");
    }
}
