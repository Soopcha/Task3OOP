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
        double averageAttendance = studentList.stream()//создает поток (stream) объектов типа Student из списка studentList.
                .mapToDouble(Student::calculateAttendancePercentage)// преобразовать каждый объект Student в double, вызывая метод calculateAttendancePercentage для каждого студента.
                .average() //вычисления среднего значения для числового потока
                .orElse(0.0); //указывает вернуть 0.0 в случае отсутствия значения (если поток пуст).

        System.out.println("Средняя посещаемость всех студентов: " + averageAttendance + "%");

        // Выводим студентов без пропусков
        double threshold = 99.99999; // Пороговое значение мб и 100 просто написать

        studentList.stream()
                .filter(student -> Math.abs(student.calculateAttendancePercentage()) > threshold)
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
                    .filter(entry -> student.getLessonsList().stream()////фильтруются только те записи, у которых ключ (предмет) присутствует в списке занятий студента.
                            .anyMatch(lesson -> lesson.getLesson().equals(entry.getKey())))
                    .anyMatch(entry ->
                            student.getLessonsList().stream()
                                    .filter(lesson -> lesson.getLesson().equals(entry.getKey()))
                                    .findFirst()
                                    .map(lesson -> lesson.getNumLessons() - entry.getValue())
                                    .orElse(0) > 0);  //есть ли хотя бы один случай, когда разница между числом занятий и посещением больше 0

            if (hasAnyAbsences) { //Если есть хотя бы один пропуск занятий, то входим в этот блок:
                //определяем самый непосещаемый предмет.
                String leastAttendedLesson = student.getAttendanceMap().entrySet().stream()
                        .filter(entry -> student.getLessonsList().stream()
                                .anyMatch(lesson -> lesson.getLesson().equals(entry.getKey())))
                        .max(Comparator.comparingInt(entry ->
                                //максимальная разница между числом занятий и посещением.
                                student.getLessonsList().stream()
                                        .filter(lesson -> lesson.getLesson().equals(entry.getKey()))
                                        .findFirst()
                                        .map(lesson -> lesson.getNumLessons() - entry.getValue())
                                        .orElse(Integer.MIN_VALUE)))
                        .map(Map.Entry::getKey)//записи берется кллюч -  сам предмет.
                        .orElse(null);  //что нет пропусков занятий --- возвращается null

                if (leastAttendedLesson != null) { //Если есть непосещаемый предмет
                    System.out.println("Студент " + student.getName() + " имеет самое непосещаемое занятие: " + leastAttendedLesson);
                }
                    /* else {  //это не нужно тк почему-то н
                    System.out.println("У студента " + student.getName() + " нет непосещаемых занятий.");
                }

                     */
            } else {
                System.out.println("У студента " + student.getName() + " нет пропусков занятий.");
            }
        });












    }
}


