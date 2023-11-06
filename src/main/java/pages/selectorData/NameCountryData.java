package pages.selectorData;

import lombok.Getter;

@Getter
public enum NameCountryData {
    RUSSIA("Россия"),
    BELARUSSIA("Республика Беларусь");
    private final String name;

    NameCountryData(String name) {
        this.name = name;
    }
}
