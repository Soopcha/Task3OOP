package task7;

public enum Weekday {
    MONDAY("Понедельник", "Monday"),
    TUESDAY("Вторник", "Tuesday"),
    WEDNESDAY("Среда", "Wednesday"),
    THURSDAY("Четверг", "Thursday"),
    FRIDAY("Пятница", "Friday"),
    SATURDAY("Суббота", "Saturday"),
    SUNDAY("Воскресенье", "Sunday");

    private final String russianName;  //мапой можно было сделать
    private final String englishName;

    Weekday(String russianName, String englishName) {
        this.russianName = russianName;
        this.englishName = englishName;
    }

    public String getRussianName() {
        return russianName;
    }

    public String getEnglishName() {
        return englishName;
    }
}
