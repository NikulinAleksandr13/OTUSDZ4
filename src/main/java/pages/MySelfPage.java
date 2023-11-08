package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.selectorData.NameCityData;
import pages.selectorData.NameCountryData;
import pages.selectorData.NameEnglishLevelData;
import pages.selectorData.NameFieldData;
import utils.DataUtils;
import org.testng.Assert;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


@Getter
public class MySelfPage extends AbsBasePage {

    public MySelfPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name = date_of_birth]")
    private WebElement birthday;

    private final String localDate = LocalDate.of(1998, Month.JULY, 12).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    // Основная информация
    @FindBy(xpath = "//input[@name= 'country']/following::div[1]")
    private WebElement countryField;
    @FindBy(xpath = "//input[@data-title= 'Город']/following::div[1]")
    private WebElement cityField;
    @FindBy(xpath = "//input[@data-title= 'Уровень знания английского языка']/following::div[1]")
    private WebElement englishLevelField;
    @FindBy(css = "#id_ready_to_relocate_0")
    private WebElement readyToRelocateNo;
    @FindBy(xpath = "//span[contains(text(), 'Нет')]")
    private WebElement readyToRelocateNoClick;
    @FindBy(css = "#id_ready_to_relocate_1")
    private WebElement readyToRelocateYes;
    @FindBy(xpath = "//span[contains(text(), 'Да')]")
    private WebElement readyToRelocateYesClick;
    @FindBy(xpath = "//input[@title = 'Полный день']")
    private WebElement formatJobFullday;
    @FindBy(xpath = "//span[contains(text(), 'Полный день')]")
    private WebElement formatJobFulldayClick;
    @FindBy(xpath = "//input[@title = 'Гибкий график']")
    private WebElement formatJobflexible;
    @FindBy(xpath = "//span[contains(text(), 'Гибкий график')]")
    private WebElement formatJobflexibleClick;
    @FindBy(xpath = "//input[@title = 'Удаленно']")
    private WebElement formatJobRelocate;
    @FindBy(xpath = "//span[contains(text(), 'Удаленно')]")
    private WebElement formatJobRelocateClick;


    // Контактная информация
    @FindBy(css = ".lk-cv-block__action.lk-cv-block__action_md-no-spacing.js-formset-add.js-lk-cv-custom-select-add")
    private WebElement addButton;
    @FindBy(xpath = "//span[@class='placeholder']")
    private WebElement listContactField;
    @FindBy(xpath = "(//button[@data-value='facebook'])[last()]")
    private WebElement listContact1;
    @FindBy(xpath = "(//button[@data-value='viber'])[last()]")
    private WebElement listContact2;
    @FindBy(xpath = "(//input[@class ='input input_straight-top-left input_straight-bottom-left lk-cv-block__input lk-cv-block__input_9 lk-cv-block__input_md-8'])[last()]")
    private WebElement contactField;

    // Другое
    @FindBy(xpath = "//option[contains(@value, 'm')]")
    private WebElement gender;
    @FindBy(xpath = "//div[@class = 'select select_full']/select[@name='gender']")
    private WebElement genderActual;

    // Опыт разработки
    @FindBy(css = ".experience-add.js-formset-add")
    private WebElement addButtonDevelop;
    @FindBy(xpath = "//select[@id = 'id_experience-0-experience']")
    private WebElement languageDevelopField;
    @FindBy(xpath = "//option[contains(@value, '10')]")
    private WebElement languageDevelop;
    @FindBy(xpath = "//div[@class = 'select select_full']/select[@name='experience-0-experience']")
    private WebElement languageDevelopActual;
    @FindBy(css = "#id_experience-0-level")
    private WebElement timeDevelopField;
    @FindBy(xpath = "//option[contains(text(), 'Только начал')]")
    private WebElement timeDevelop;
    @FindBy(xpath = "//div[@class = 'select select_full']/select[@name='experience-0-level']")
    private WebElement timeDevelopActual;
    @FindBy(xpath = "(//div[@class = 'experience-row__remove ic-close js-formset-delete'])[last()]")
    private WebElement deleteDevelop;

    // Кнопка сохранения
    @FindBy(xpath = "//button[@title = 'Сохранить и заполнить позже']")
    private WebElement saveButton;



    public void sendAllFields() {
        clearAndSend(setSelector(NameFieldData.FNAME.getName()), DataUtils.fakerName);
        clearAndSend(setSelector(NameFieldData.FNAME_LATIN.getName()), DataUtils.fakerNameLatin);
        clearAndSend(setSelector(NameFieldData.LNAME.getName()), DataUtils.fakerLastName);
        clearAndSend(setSelector(NameFieldData.LNAME_LATIN.getName()), DataUtils.fakerLastNameLatin);
        clearAndSend(setSelector(NameFieldData.BLOG_NAME.getName()), DataUtils.fakerNameBlog);
        clearAndSend(birthday, localDate);

        //  Основная информация
        countryField.click();
        waiters.waitElementVisible(setLocator(NameCountryData.BELARUSSIA.getName()));
        setLocator(NameCountryData.BELARUSSIA.getName()).click();
        cityField.click();
        waiters.waitElementVisible(setLocator(NameCityData.BORISOV.getName()));
        setLocator(NameCityData.BORISOV.getName()).click();
        englishLevelField.click();
        waiters.waitElementVisible(setLocator(NameEnglishLevelData.BEGINNER.getName()));
        setLocator(NameEnglishLevelData.BEGINNER.getName()).click();
        choiceRadioButton();
        clickCheckBox();

        // Контактная информация
        addButton.click();
        listContactField.click();
        waiters.waitElementVisible(listContact1);
        listContact1.click();
        clearAndSend(contactField, DataUtils.fakerContact1);
        addButton.click();
        listContactField.click();
        waiters.waitElementVisible(listContact2);
        listContact2.click();
        clearAndSend(contactField, DataUtils.fakerContact2);


        // Другое
        setSelector(NameFieldData.GENDER.getName()).click();
        gender.click();
        clearAndSend(setSelector(NameFieldData.COMPANY.getName()), DataUtils.fakerCompany);
        clearAndSend(setSelector(NameFieldData.WORK.getName()), DataUtils.fakerPosition);

        // Опыт разработки
        addButtonDevelop.click();
        languageDevelopField.click();
        languageDevelop.click();
        timeDevelopField.click();
        timeDevelop.click();

        //Кнопка сохранения
        saveButton.click();
    }

    public void choiceRadioButton() {
        WebElement[] arrayRadioButton = {readyToRelocateNo, readyToRelocateYes};
        WebElement element = getRandomElement(arrayRadioButton);
        System.out.println(element);
        if (element.isSelected()) {
            System.out.println("Радиобаттон уже был выбран");
        } else {
            if (element == readyToRelocateNo) {
                readyToRelocateNoClick.click();
            } else {
                readyToRelocateYesClick.click();
            }
        }
    }

    public void clickCheckBox() {
        WebElement[] arrayCheckBox = {formatJobFullday, formatJobflexible, formatJobRelocate};
        WebElement element = getRandomElement(arrayCheckBox);
        System.out.println(element);
        if (element.isSelected()) {
            System.out.println("Чекбокс уже выбран");
        } else {
            if (element == formatJobFullday) {
                formatJobFulldayClick.click();
            } else if (element == formatJobflexible) {
                formatJobflexibleClick.click();
            } else {
                formatJobRelocateClick.click();
            }
        }
        }

    public void assertField(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }
    }
