package pages.selectorData;

import lombok.Getter;

@Getter
public enum NameEnglishLevelData {
    BEGINNER ("Начальный уровень (Beginner)"),
    ELEMENTARY ("Элементарный уровень (Elementary)"),
    PRE_INTERMEDIATE ("Ниже среднего (Pre-Intermediate)"),
    INTERMEDIATE ("Средний (Intermediate)"),
    UPPER_INTERMEDIATE ("Выше среднего (Upper Intermediate)"),
    ADVANCED ("Продвинутый (Advanced)"),
    MASTERY ("Супер продвинутый (Mastery)");

    private String name;

    NameEnglishLevelData(String name) {
        this.name = name;
    }

}
