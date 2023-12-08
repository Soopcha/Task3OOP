package task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainAPI {
    public static void main(String[] args) {
        List<Lessons> lessonsList = new ArrayList<>();

        lessonsList.add(new Lessons(145, "Математика"));
        lessonsList.add(new Lessons(254, "Русский"));
        lessonsList.add(new Lessons(398, "Биология"));

        lessonsList.forEach(lesson -> System.out.println("Количество уроков: " + lesson.getNumLessons() + ", Название урока: " + lesson.getLesson()));

        System.out.println("\n");

        Map<String, Integer> map1man = Map.of("Математика", 123, "Русский", 123, "Биология", 123);
        Map<String, Integer> map2man = Map.of("Математика", 13, "Русский", 13, "Биология", 23);
        Map<String, Integer> map3man = Map.of("Математика", 0, "Русский", 0, "Биология", 0);

        List<Student> studentList = List.of(
                new Student("Паша", 2, map1man, lessonsList),
                new Student("Сеня", 2, map2man, lessonsList),
                new Student("Сеня", 2, map3man, lessonsList),
                new Student("Олежик", 2, Map.of("Математика", 145, "Русский", 254, "Биология", 398), lessonsList)
        );

        // Рассчитываем среднюю посещаемость
        double averageAttendance = studentList.stream()
                .mapToDouble(Student::calculateAttendancePercentage)
                .average()
                .orElse(0.0);

        System.out.println("Средняя посещаемость всех студентов: " + averageAttendance + "%");

        // Выводим студентов без пропусков
        double threshold = 99.99999; // Пороговое значение

        studentList.stream()
                .filter(student -> Math.abs(student.calculateAttendancePercentage() - 0.0) > threshold)
                .forEach(student -> System.out.println("Студент " + student.getName() + " имеет среднюю посещаемость " + student.calculateAttendancePercentage() + "%."));



/*
        // Выводим самые непосещаемые занятия
        Map<String, Integer> lessonAttendanceMap = new HashMap<>();
        for (Student students : studentList) {
            students.getAttendanceMap().forEach((lesson, attendance) ->
                    lessonAttendanceMap.merge(lesson, attendance, Integer::sum));
        }

        List<String> leastAttendedLessons = lessonAttendanceMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Самые непосещаемые занятия: " + leastAttendedLessons);


 */
        // Выводим самые непосещаемые занятия
        Map<String, Integer> lessonAttendanceMap = studentList.stream()
                .flatMap(student -> student.getAttendanceMap().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));

        List<String> leastAttendedLessons = lessonAttendanceMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Самые непосещаемые занятия: " + leastAttendedLessons);

    }
}


