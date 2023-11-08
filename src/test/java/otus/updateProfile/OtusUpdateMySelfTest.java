package otus.updateProfile;

import components.ModalAutorization;
import factory.drivers.nameData.BrowserNameData;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pages.selectorData.NameCityData;
import pages.selectorData.NameCountryData;
import pages.selectorData.NameEnglishLevelData;
import pages.selectorData.NameFieldData;
import utils.DataUtils;


public class OtusUpdateMySelfTest {
    protected WebDriver driver;
    private final Logger logger = LogManager.getLogger(OtusUpdateMySelfTest.class);
    private MySelfPage mySelfPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private StartPage startPage;
    private MySelfPageResult mySelfPageResult;
    private ModalAutorization modalAutorization;


    @BeforeMethod
    public void init() {
        driver = new WebDriverFactory().getDriver(BrowserNameData.FIREFOX);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        mySelfPage = new MySelfPage(driver);
        startPage = new StartPage(driver);
        mySelfPageResult = new MySelfPageResult(driver);
        modalAutorization = new ModalAutorization(driver);
    }

    @Test
    public void otusUpdateMySelfTest() {
        logger.info("Открытие сайта");
        startPage.openPage("/");
        modalAutorization.modalNotPresent();
        logger.info("Открытие модального окна авторизации");
        startPage.signIn();
        modalAutorization.modalPresent();
        logger.info("Вход в ЛК");
        loginPage.login();
        logger.info("Переход в Мои данные");
        myAccountPage.goToMySelf();
        logger.info("Заполнение полей и сохранение результатов");
        mySelfPage.sendAllFields();
        logger.info("Проверка успешного сохранения");
        mySelfPageResult.assertField(mySelfPageResult.setLocator(
                DataUtils.fakerName, DataUtils.fakerLastName).getText(),
                DataUtils.fakerName + " " + DataUtils.fakerLastName, "Имя и фамилия не соответствуют");
        driver.quit();

        // Заново зайти что бы проверить содержимое
        driver = new WebDriverFactory().getDriver(BrowserNameData.FIREFOX);
        startPage = new StartPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        mySelfPage = new MySelfPage(driver);
        modalAutorization = new ModalAutorization(driver);
        logger.info("Открытие сайта");
        startPage.openPage("/");
        logger.info("Открытие модального окна авторизации");
        startPage.signIn();
        logger.info("Вход в ЛК");
        loginPage.login();
        logger.info("Переход в Мои данные");
        myAccountPage.goToMySelf();
        logger.info("Начало проверок");

        // личные данные
        mySelfPage.assertField(mySelfPage.setSelector(NameFieldData.FNAME.getName()).getAttribute("value"), DataUtils.fakerName, "Имя не совпадает");
        mySelfPage.assertField(mySelfPage.setSelector(NameFieldData.FNAME_LATIN.getName()).getAttribute("value"), DataUtils.fakerNameLatin, "Имя на латиницей не совпадает");
        mySelfPage.assertField(mySelfPage.setSelector(NameFieldData.LNAME.getName()).getAttribute("value"), DataUtils.fakerLastName, "Фамилия не совпадает");
        mySelfPage.assertField(mySelfPage.setSelector(NameFieldData.LNAME_LATIN.getName()).getAttribute("value"), DataUtils.fakerLastNameLatin, "Фамилия латиницей не совпадает");
        mySelfPage.assertField(mySelfPage.setSelector(NameFieldData.BLOG_NAME.getName()).getAttribute("value"), DataUtils.fakerNameBlog, "Имя блога не совпадает");
        mySelfPage.assertField(mySelfPage.getBirthday().getAttribute("value"), mySelfPage.getLocalDate(), "Дата рождения не совпадает");

////        // основная информация
        mySelfPage.assertField(mySelfPage.setLocator(NameCountryData.BELARUSSIA.getName()).getAttribute("title"), NameCountryData.BELARUSSIA.getName(), "Страна не совпадает");
        mySelfPage.assertField(mySelfPage.setLocator(NameCityData.MINSK.getName()).getAttribute("title"), NameCityData.MINSK.getName(), "Город не совпадает");
        mySelfPage.assertField(mySelfPage.setLocator(NameEnglishLevelData.BEGINNER.getName()).getAttribute("title"), NameEnglishLevelData.BEGINNER.getName(), "Уровень английского не совпадает");


////        // другое
        mySelfPage.assertField(mySelfPage.setSelector(NameFieldData.COMPANY.getName()).getAttribute("value"), DataUtils.fakerCompany, "Компания не совпадает");
        mySelfPage.assertField(mySelfPage.setSelector(NameFieldData.WORK.getName()).getAttribute("value"), DataUtils.fakerPosition, "Должность не совпадает");

        // Удаление опыта разработки
        mySelfPage.getDeleteDevelop().click();
        mySelfPage.getSaveButton().click();
    }

    @AfterMethod
    public void downDriver() {
        if (driver != null) {
//            driver.close();
            driver.quit();
        }
    }
}
