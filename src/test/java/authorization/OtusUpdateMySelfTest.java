package authorization;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MySelfPage;
import pages.MyAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DataUtils;


public class OtusUpdateMySelfTest {
    private final String BASE_URL = System.getProperty("base.url", "http://otus.ru/");
    private WebDriver driver;
    private final Logger logger = LogManager.getLogger(OtusUpdateMySelfTest.class);
    public MySelfPage mySelfPage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void init() {
        driver = new WebDriverFactory().create();
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        mySelfPage = new MySelfPage(driver);
    }

    @Test
    public void otusUpdateMySelfTest() {
        logger.info("Открытие сайта");
        driver.get(BASE_URL);
        logger.info("Вход в ЛК");
        loginPage.login();
        logger.info("Переход в Мои данные");
        myAccountPage.goToMySelf();
        logger.info("Заполнение полей");
        mySelfPage.sendAllFields();
        logger.info("Сохранение результатов");
        mySelfPage.savePage();
        Assert.assertNotEquals(mySelfPage.getSaveUrl(), mySelfPage.getUrlPage(),"URL страницы не совпадает");
        downDriver();

        // Заново зайти что бы проверить содержимое
        driver = new WebDriverFactory().create();
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        mySelfPage = new MySelfPage(driver);
        logger.info("Открытие сайта");
        driver.get(BASE_URL);
        logger.info("Вход в ЛК");
        loginPage.login();
        logger.info("Переход в Мои данные");
        myAccountPage.goToMySelf();
        logger.info("Начало проверок");
        SoftAssert softAssert = new SoftAssert();

        // личные данные

        softAssert.assertEquals(mySelfPage.getName().getAttribute("value"), DataUtils.fakerName,"Имя не совпадает");
        softAssert.assertEquals(mySelfPage.getNameLatin().getAttribute("value"), DataUtils.fakerNameLatin,"Имя на латиницей не совпадает");
        softAssert.assertEquals(mySelfPage.getLastName().getAttribute("value"), DataUtils.fakerLastName,"Фамилия не совпадает");
        softAssert.assertEquals(mySelfPage.getLastNameLatin().getAttribute("value"), DataUtils.fakerLastNameLatin,"Фамилия латиницей не совпадает");
        softAssert.assertEquals(mySelfPage.getNameBlog().getAttribute("value"), DataUtils.fakerNameBlog,"Имя блога не совпадает");
        softAssert.assertEquals(mySelfPage.getBirthday().getAttribute("value"), mySelfPage.getLocalDate(),"Дата рождения не совпадает");

////        // основная информация
        softAssert.assertEquals(mySelfPage.getCountryActual().getText(), DataUtils.countryExpected,"Страна не совпадает");
        softAssert.assertEquals(mySelfPage.getCityActual().getText(), DataUtils.cityExpected,"Город не совпадает");
        softAssert.assertEquals(mySelfPage.getEnglishLevelActual().getText(), DataUtils.englishLevelExpected,"Уровень английского не совпадает");


////        // другое
        softAssert.assertEquals(mySelfPage.getCompany().getAttribute("value"), DataUtils.fakerComany,"Компания не совпадает");
        softAssert.assertEquals(mySelfPage.getPosition().getAttribute("value"), DataUtils.fakerPosition,"Должность не совпадает");


        softAssert.assertAll();
    }

    @AfterMethod
    public void downDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
