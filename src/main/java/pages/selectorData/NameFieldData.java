package pages.selectorData;

import lombok.Getter;

@Getter
public enum NameFieldData {
    FNAME ("fname") ,
    FNAME_LATIN ("fname_latin"),
   LNAME ("lname"),
    LNAME_LATIN ("lname_latin"),
    BLOG_NAME ("blog_name"),
    GENDER ("gender"),
    COMPANY ("company"),
    WORK ("work");

    private String name;
    NameFieldData(String name) {
        this.name = name;
    }
}
