package pages;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DataUtils;
import waiters.Waiters;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


@Getter
public class MySelfPage extends AbsPage {
    Faker faker = new Faker();
    Waiters waiters;

    public MySelfPage(WebDriver driver) {
        super(driver);
        this.waiters = new Waiters(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#id_fname")
    private WebElement name;
    @FindBy(css = "#id_fname_latin")
    private WebElement nameLatin;
    @FindBy(css = "#id_lname")
    private WebElement lastName;
    @FindBy(css = "#id_lname_latin")
    private WebElement lastNameLatin;
    @FindBy(css = "#id_blog_name")
    private WebElement nameBlog;
    @FindBy(css = "[name = date_of_birth]")
    private WebElement birthday;

    private String localDate = LocalDate.of(1998, Month.JULY, 12).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    // Основная информация
    @FindBy(xpath = "//input[@name= 'country']/following::div[1]")
    private WebElement countryField;
    @FindBy(xpath = "//button[contains(@title,'Республика Беларусь')]")
    private WebElement country;
    @FindBy(xpath = "(//div[@class = 'input input_full lk-cv-block__input lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation'])[1]")
    private WebElement countryActual;
    @FindBy(xpath = "//input[@data-title= 'Город']/following::div[1]")
    private WebElement cityField;
    @FindBy(xpath = "//button[contains(@title,'Борисов')]")
    private WebElement city;
    @FindBy(xpath = "(//div[@class = \"input input_full lk-cv-block__input lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[2]")
    private WebElement cityActual;
    @FindBy(xpath = "//input[@data-title= 'Уровень знания английского языка']/following::div[1]")
    private WebElement englishLevelField;
    @FindBy(xpath = "//button[contains(@title,'Средний')]")
    private WebElement englishLevel;
    @FindBy(xpath = "(//div[@class = \"input input_full lk-cv-block__input lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation\"])[3]")
    private WebElement englishLevelActual;
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
    @FindBy(css = "#id_gender")
    private WebElement genderField;
    @FindBy(xpath = "//option[contains(@value, 'm')]")
    private WebElement gender;
    @FindBy(xpath = "(//div[@class = 'select select_full'])[1]")
    private WebElement genderActual;
    @FindBy(css = "#id_company")
    private WebElement company;
    @FindBy(css = "#id_work")
    private WebElement position;

    // Опыт разработки
    @FindBy(css = ".experience-add.js-formset-add")
    private WebElement addButtonDevelop;
    @FindBy(xpath = "//select[@id = 'id_experience-0-experience']")
    private WebElement languageDevelopField;
    @FindBy(xpath = "//option[contains(@value, '10')]")
    private WebElement languageDevelop;
    @FindBy(xpath = "(//div[@class = 'select select_full'])[2]")
    private WebElement languageDevelopActual;
    @FindBy(css = "#id_experience-0-level")
    private WebElement timeDevelopField;
    @FindBy(xpath = "//option[contains(text(), 'Только начал')]")
    private WebElement timeDevelop;
    @FindBy(xpath = "(//div[@class = 'select select_full'])[3]")
    private WebElement timeDevelopActual;

    // Кнопка сохранения
    @FindBy(xpath = "//button[@title = 'Сохранить и заполнить позже']")
    private WebElement saveButton;

    // Адреса страниц для проверки
    String UrlPage = "https://otus.ru/lk/biography/personal/";
    String saveUrl = "https://otus.ru/lk/biography/cv/";


    public void sendAllFields() {
        clearAndSend(name, DataUtils.fakerName);
        clearAndSend(nameLatin, DataUtils.fakerNameLatin);
        clearAndSend(lastName, DataUtils.fakerLastName);
        clearAndSend(lastNameLatin, DataUtils.fakerLastNameLatin);
        clearAndSend(nameBlog, DataUtils.fakerNameBlog);
        clearAndSend(birthday, localDate);

        //  Основная информация
        clickElement(countryField);
        waiters.waitElementVisible(country);
        clickElement(country);
        waiters.waitElementVisible(city);
        clickElement(cityField);
        clickElement(city);
        clickElement(englishLevelField);
        waiters.waitElementVisible(englishLevel);
        clickElement(englishLevel);
        choiceRadioButton();
        clickCheckBox();

        // Контактная информация
        clickElement(addButton);
        waiters.waitElementVisible(listContact1);
        clickElement(listContactField);
        clickElement(listContact1);
        clearAndSend(contactField, DataUtils.fakerContact1);
        clickElement(addButton);
        waiters.waitElementVisible(listContact2);
        clickElement(listContactField);
        clickElement(listContact2);
        clearAndSend(contactField, DataUtils.fakerContact2);


        // Другое
        clickElement(genderField);
        clickElement(gender);
        clearAndSend(company, DataUtils.fakerComany);
        clearAndSend(position, DataUtils.fakerPosition);

        // Опыт разработки
        clickElement(addButtonDevelop);
        clickElement(languageDevelopField);
        clickElement(languageDevelop);
        clickElement(timeDevelopField);
        clickElement(timeDevelop);

    }

    public void savePage() {
        clickElement(saveButton);
    }


    public void choiceRadioButton() {
        WebElement[] arrayRadioButton = {readyToRelocateNo, readyToRelocateYes};
        WebElement element = getRandomElement(arrayRadioButton);
        System.out.println(element);
        if (element.isSelected()) {
            System.out.println("Радиобаттон уже был выбран");
        } else {
            if (element == readyToRelocateNo) {
                clickElement(readyToRelocateNoClick);
            } else {
                clickElement(readyToRelocateYesClick);
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
                clickElement(formatJobFulldayClick);
            } else if (element == formatJobflexible) {
                clickElement(formatJobflexibleClick);
            } else {
                clickElement(formatJobRelocateClick);
            }

        }
    }


}
