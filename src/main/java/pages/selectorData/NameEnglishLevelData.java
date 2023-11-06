package pages.selectorData;

import lombok.Getter;

@Getter
public enum NameEnglishLevelData {
    Beginner ("Начальный уровень (Beginner)"),
    Elementary ("Элементарный уровень (Elementary)"),
    Pre_Intermediate ("Ниже среднего (Pre-Intermediate)"),
    Intermediate ("Средний (Intermediate)"),
    Upper_Intermediate ("Выше среднего (Upper Intermediate)"),
    Advanced ("Продвинутый (Advanced)"),
    Mastery ("Супер продвинутый (Mastery)");

    private String name;

    NameEnglishLevelData(String name) {
        this.name = name;
    }

}
