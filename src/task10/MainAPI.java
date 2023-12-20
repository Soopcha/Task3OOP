package task10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainAPI {
  /*  public static void main(String[] args) {
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
                new Student("Паша",  map1man, lessonsList),
                new Student("Сеня",  map2man, lessonsList),
                new Student("Сеня",  map3man, lessonsList),
                new Student("Олежик" , map4man, lessonsList)
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
   /*         } else {
                System.out.println("У студента " + student.getName() + " нет пропусков занятий.");
            }
        });












    }

    */


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
                new Student("Паша", map1man),
                new Student("Сеня", map2man),
                new Student("Сеня", map3man),
                new Student("Олежик", map4man)
        );

        // Рассчитываем среднюю посещаемость по группе
        double averageAttendance = studentList.stream()
                .mapToDouble(student -> Function.calculateAttendancePercentage(student, new Group(2, studentList, lessonsList)))
                //mapToDouble применяет функцию calculateAttendancePercentage к каждому студенту, возвращая стрим примитивов double.
                .average()//вычисляет среднее значение
                .orElse(0.0); //предоставляет значение по умолчанию, если стрим пустпредоставляет значение по умолчанию, если стрим пуст


        System.out.println("Средняя посещаемость всех студентов: " + averageAttendance + "%");

        // Выводим студентов без пропусков
        double threshold = 99.99999; // Пороговое значение
        studentList.stream()
                .filter(student -> Math.abs(Function.calculateAttendancePercentage(student, new Group(2, studentList, lessonsList)) - 0.0) > threshold)
                //filter оставляет только тех студентов, у которых посещаемость превышает пороговое значение.
                .forEach(student -> System.out.println("Студент " + student.getName() + " имеет среднюю посещаемость " + Function.calculateAttendancePercentage(student, new Group(2, studentList, lessonsList)) + "%."));
        //forEach выводит информацию о каждом студенте без пропусков.

        System.out.println("\n");

        // Выводим самые непосещаемые занятия для каждого студента
        studentList.forEach(student -> {
            //перебирает каждого студента в studentList
            boolean hasAnyAbsences = student.getAttendanceMap().entrySet().stream()
                    //Создается булева перем, которая проверяет, есть ли у студента хотя бы одно пропущенное занятие.
                    //Используется Stream API для обработки записей о посещении студента (entrySet() используется для получения набора записей)
                    .filter(entry -> lessonsList.stream()//
                            // фильтруются: только те записи, у которых ключ (предмет) присутствует в списке занятий студента.
                            .anyMatch(lesson -> lesson.getLesson().equals(entry.getKey())))
                    .anyMatch(entry ->
                            //Проверка, есть ли хотя бы один случай, когда разница между числом занятий и посещением больше 0
                            lessonsList.stream()
                                    .filter(lesson -> lesson.getLesson().equals(entry.getKey()))
                                    .findFirst()
                                    .map(lesson -> lesson.getNumLessons() - entry.getValue())
                                    .orElse(0) > 0);  //есть ли хотя бы один случай, когда разница между числом занятий и посещением больше 0

            if (hasAnyAbsences) { //Если есть хотя бы один пропуск занятий, то входим в этот блок:
                //определяем самый непосещаемый предмет.
                String leastAttendedLesson = student.getAttendanceMap().entrySet().stream()
                        //Определяется самый непосещаемый предмет
                        //Фильтруются только те записи, у которых ключ (предмет) присутствует в списке занятий студента.
                        //Вычисляется максимальная разница между числом занятий и посещением.
                        //Возвращается ключ (предмет) с максимальной разницей или null, если нет пропусков занятий.
                        .filter(entry -> lessonsList.stream()
                                .anyMatch(lesson -> lesson.getLesson().equals(entry.getKey())))
                        .max(Comparator.comparingInt(entry ->
                                //максимальная разница между числом занятий и посещением.
                                lessonsList.stream()
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


