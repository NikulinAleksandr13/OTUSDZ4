package pages.selectorData;

import lombok.Getter;

@Getter
public enum NameCityData {
    BORISOV ("Борисов"),
    GOMEL ("Гомель"),
    MINSK ("Минск"),
    MOSKOW ("Москва");

    private String name;

    NameCityData(String name) {
        this.name = name;
    }
}
