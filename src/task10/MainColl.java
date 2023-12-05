package task10;
//КОЛЛЕКЦИИ
//4 таск мне
/*
группы студенты занятия посещаемость. Вывести студентов без пропусков занятий,
вывести самые непосещаемые занятия, вывести среднюю посещаемость
 */
//след такс тот же так но с помощью стрим api

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainColl {
    public static void main(String[] args) {


        List<Lessons> lessonsList = new ArrayList<>();

        lessonsList.add(new Lessons(145, "Математика"));
        lessonsList.add(new Lessons(254, "Русский"));
        lessonsList.add(new Lessons(398, "Биология"));

        for (Lessons lesson : lessonsList) {
            System.out.println("Количество уроков: " + lesson.getNumLessons() + ", Название урока: " + lesson.getLesson());
        }

        System.out.println();
        System.out.println();


        Map<String, Integer> map1man = new HashMap<>();
        map1man.put("Математика", 123);
        map1man.put("Русский", 123);
        map1man.put("Биология", 123);

        Map<String, Integer> map2man = new HashMap<>();
        map2man.put("Математика", 13);
        map2man.put("Русский", 13);
        map2man.put("Биология", 23);


        Map<String, Integer> map3man = new HashMap<>();
        map2man.put("Математика", 0);
        map2man.put("Русский", 0);
        map2man.put("Биология", 0);
        Student student3 = new Student("Сеня", 2, map3man, lessonsList);



        Student student = new Student("Паша", 2, map1man, lessonsList);
        student.checkAttendance();
        double attendancePercentage = student.calculateAttendancePercentage();
        System.out.println("Процент посещаемости студента: " + attendancePercentage + "%");


        System.out.println();
        System.out.println();
        System.out.println();


        Student student2 = new Student("Сеня", 2, map2man, lessonsList);
        student2.checkAttendance();
        double attendancePercentage2 = student2.calculateAttendancePercentage();
        System.out.println("Процент посещаемости студента: " + attendancePercentage2 + "%");

        System.out.println();
        System.out.println();

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);


        // Рассчитываем среднюю посещаемость
        double totalAttendance = 0.0;
        for (Student st : studentList) {
            totalAttendance += st.calculateAttendancePercentage();
        }

        double averageAttendance = totalAttendance / studentList.size();

        System.out.println("Средняя посещаемость всех студентов: " + averageAttendance + "%");









        double threshold = 0.00001; // Пороговое значение

        for (Student st : studentList) {
            double averageAttend = st.calculateAttendancePercentage();

            // Проверяем, близко ли значение к 0%
            if (Math.abs(averageAttend - 0.0) < threshold) {
                System.out.println("Студент " + st.getName() + " имеет среднюю посещаемость " + averageAttendance + "%.");
            }
        }
    }


}
