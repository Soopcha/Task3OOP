package task10;

import java.util.*;
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
        Map<String, Integer> map4man = Map.of("Математика", 145, "Русский", 254, "Биология", 398);

        List<Student> studentList = List.of(
                new Student("Паша", 2, map1man, lessonsList),
                new Student("Сеня", 2, map2man, lessonsList),
                new Student("Сеня", 2, map3man, lessonsList),
                new Student("Олежик", 2, map4man, lessonsList)
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

        System.out.println();
        System.out.println();
        System.out.println();

/*
        studentList.forEach(student -> {
            String leastAttendedLesson = student.getAttendanceMap().entrySet().stream()
                    //карту посещений превращаем в набор записей (ключ-значение) и создаем поток (Stream) из этого набора.
                    .filter(entry -> student.getLessonsList().stream()
                            .anyMatch(lesson -> lesson.getLesson().equals(entry.getKey())))
                    // фильтруем записи в этом потоке, оставляя только те записи, ключи которых присутствуют в списке занятий студента
                    .max(Comparator.comparingInt(entry ->
                            student.getLessonsList().stream()
                                    .filter(lesson -> lesson.getLesson().equals(entry.getKey()))
                                    .findFirst()
                                    .map(lesson -> lesson.getNumLessons() - entry.getValue())
                                    .orElse(0)))
                    .map(Map.Entry::getKey)
                    .orElse(null);

            if (leastAttendedLesson != null) {
                System.out.println("Студент " + student.getName() + " имеет самое непосещаемое занятие: " + leastAttendedLesson);
            } else {
                System.out.println("У студента " + student.getName() + " нет непосещаемых занятий.");
            }
        });
        */



        studentList.forEach(student -> {
            boolean hasAnyAbsences = student.getAttendanceMap().entrySet().stream()
                    .filter(entry -> student.getLessonsList().stream()
                            .anyMatch(lesson -> lesson.getLesson().equals(entry.getKey())))
                    .anyMatch(entry ->
                            student.getLessonsList().stream()
                                    .filter(lesson -> lesson.getLesson().equals(entry.getKey()))
                                    .findFirst()
                                    .map(lesson -> lesson.getNumLessons() - entry.getValue())
                                    .orElse(0) > 0);

            if (hasAnyAbsences) {
                String leastAttendedLesson = student.getAttendanceMap().entrySet().stream()
                        .filter(entry -> student.getLessonsList().stream()
                                .anyMatch(lesson -> lesson.getLesson().equals(entry.getKey())))
                        .max(Comparator.comparingInt(entry ->
                                student.getLessonsList().stream()
                                        .filter(lesson -> lesson.getLesson().equals(entry.getKey()))
                                        .findFirst()
                                        .map(lesson -> lesson.getNumLessons() - entry.getValue())
                                        .orElse(Integer.MIN_VALUE)))
                        .map(Map.Entry::getKey)
                        .orElse(null);

                if (leastAttendedLesson != null) {
                    System.out.println("Студент " + student.getName() + " имеет самое непосещаемое занятие: " + leastAttendedLesson);
                } else {
                    System.out.println("У студента " + student.getName() + " нет непосещаемых занятий.");
                }
            } else {
                System.out.println("У студента " + student.getName() + " нет пропусков занятий.");
            }
        });












    }
}


