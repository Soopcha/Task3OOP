package task7;

public class MainEnum {
    public static void main(String[] args) {

        Weekday today = Weekday.FRIDAY;
        System.out.println("На русском " + today.getRussianName());
        System.out.println("На английском " + today.getEnglishName());

        //все вывести
        for (Weekday day : Weekday.values()) {
            System.out.println(day.name() + "        " + day.getRussianName() + " / " + day.getEnglishName());
        }
    }

}
