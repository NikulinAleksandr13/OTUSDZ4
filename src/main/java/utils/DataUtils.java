package utils;

import com.github.javafaker.Faker;

public class DataUtils {
    private static final Faker faker = new Faker();
    
    public static final String fakerName = faker.name().firstName();
    public static final String fakerNameLatin = faker.name().firstName();
    public static final String fakerLastName = faker.name().lastName();
    public static final String fakerLastNameLatin = faker.name().lastName();
    public static final String fakerNameBlog = faker.regexify("[a-z]{6}\\.[a-z]{3}");
    public static final String fakerBirthday = "12.07.1998";
    public  static final String fakerCompany = faker.regexify("[a-z]{3} '[a-z]{6}'");
    public static final String fakerPosition = faker.regexify("[a-z]{6}");
    public static final String fakerContact1 = faker.regexify("[a-z]{4}/[0-9]{10}");
    public static final String fakerContact2 = faker.regexify("[a-z]{4}/[0-9]{10}");
}
