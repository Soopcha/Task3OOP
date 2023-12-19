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
import java.util.stream.Collectors;

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
        map3man.put("Математика", 0);
        map3man.put("Русский", 0);
        map3man.put("Биология", 0);

        Map<String, Integer> map4man = new HashMap<>();
        map4man.put("Математика", 145);
        map4man.put("Русский", 254);
        map4man.put("Биология", 398);



        Student student = new Student("Паша", map1man);
        Student student2 = new Student("Сеня", map2man);
        Student student3 = new Student("Сеня",  map3man);
        Student student4 = new Student("Олежик",  map4man);


        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        Group group = new Group(2,studentList, lessonsList);

        Function.checkAttendance(student,group);
        double attendancePercentage = Function.calculateAttendancePercentage(student,group);
        System.out.println("Процент посещаемости студента: " + attendancePercentage + "%");


        System.out.println();
        System.out.println();
        System.out.println();



        Function.checkAttendance(student2,group);
        double attendancePercentage2 = Function.calculateAttendancePercentage(student2,group);
        System.out.println("Процент посещаемости студента: " + attendancePercentage2 + "%");

        System.out.println();
        System.out.println();

        Function.checkAttendance(student3,group);
        double attendancePercentage3 = Function.calculateAttendancePercentage(student3,group);
        System.out.println("Процент посещаемости студента: " + attendancePercentage3 + "%");

        System.out.println();
        System.out.println();






        // Рассчитываем среднюю посещаемость по группе
        double totalAttendance = 0.0;
        for (Student st : studentList) {
            totalAttendance += Function.calculateAttendancePercentage(st,group);
        }

        double averageAttendance = totalAttendance / studentList.size();

        System.out.println("Средняя посещаемость всех студентов: " + averageAttendance + "%");








        //выводим челов у которых нет пропусков
        double threshold = 99.99999; // Пороговое значение

        for (Student st : studentList) {
            double averageAttend = Function.calculateAttendancePercentage(st,group);

            // Проверяем, близко ли значение к 0%
            if (Math.abs(averageAttend - 0.0) > threshold) {
                System.out.println("Студент " + st.getName() + " имеет среднюю посещаемость " + averageAttend + "%.");
            }
        }


        System.out.println();
        System.out.println();



        // Выводим самые непосещаемые занятия для каждого студента
        for (Student students : studentList) {
            String leastAttendedLesson = null;
            int minAttendance = 0;

            for (Map.Entry<String, Integer> entry : students.getAttendanceMap().entrySet()) {// .entrySet - возвращает множество обьектов типа Map.Entry
                for (Lessons lessons: group.getLessonsList()) {
                    if (lessons.getLesson() == entry.getKey()) {
                        if ((lessons.getNumLessons() - entry.getValue()) > minAttendance) {
                            minAttendance = lessons.getNumLessons() - entry.getValue();
                            leastAttendedLesson = entry.getKey();
                        }
                    }
                }
            }

            if (leastAttendedLesson != null) {
                System.out.println("Студент " + students.getName() + " имеет самое непосещаемое занятие: " + leastAttendedLesson);
            } else {
                System.out.println("У студента " + students.getName() + " нет непосещаемых занятий.");
            }
        }


    }


}
