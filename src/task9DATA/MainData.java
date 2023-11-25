package task9DATA;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// работа с датами и интервалами
// мой - 3   7
//распарсить дату из стр (те извлечь инфу о дате из стр)
//Преобразовать ZonedDateTime в OffsetDateTime
public class MainData {

    public static LocalDate parseDate(String dateString) {
        String pattern = "yyyy-MM-dd";
        try {
            //создает форматтер с указанным шаблоном
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);  //разбора строки с использованием указанного форматтера
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка преобразования даты: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String dateString = "2023-05-17";

        LocalDate parsedDate = parseDate(dateString);

        if (parsedDate != null) {
            System.out.println("Ваша дата: " + parsedDate);
        } else {
            System.out.println("Не удалось распарсить дату.");
        }
        System.out.println();
        System.out.println();








        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        // Преобразование в OffsetDateTime
        OffsetDateTime offsetDateTime = zonedDateTime.toOffsetDateTime();

        System.out.println("ZonedDateTime: " + zonedDateTime);  //Включает информацию о дне, времени и временной зоне.
        System.out.println("OffsetDateTime: " + offsetDateTime);
    }

}
