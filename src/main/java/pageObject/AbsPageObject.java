package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import waiters.Waiters;

public abstract class AbsPageObject extends Helper {
    protected Waiters waiters;

    public AbsPageObject(WebDriver driver) {
        super(driver);
        this.waiters = new Waiters(driver);

        PageFactory.initElements(driver, this);
    }
}
