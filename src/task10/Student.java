package task10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private Map<String,Integer> attendanceMap;

    public Map<String, Integer> getAttendanceMap() {
        return attendanceMap;
    }

    public void setAttendanceMap(Map<String, Integer> attendanceMap) {
        this.attendanceMap = attendanceMap;
    }


    public Student(String name, Map<String, Integer> attendanceMap) {
        this.name = name;
        this.attendanceMap = attendanceMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


   /* public void checkAttendance() {
        for (Map.Entry<String, Integer> entry : attendanceMap.entrySet()) {
            String lessonName = entry.getKey();
            Integer attendedLessons = entry.getValue();

            for (Lessons lesson : lessonsList) {
                if (lesson.getLesson().equals(lessonName) && attendedLessons < lesson.getNumLessons()) {
                    System.out.println("Студент пропустил уроки '" + lessonName + "'.");
                    break; // Если урок найден, прекращаем поиск в этом листе уроков
                }
            }
        }
    }


    public double calculateAttendancePercentage() { //считает проуннт посещаемости
        int totalLessons = 0;
        int attendedLessons = 0;

        for (Map.Entry<String, Integer> entry : attendanceMap.entrySet()) {
            String lessonName = entry.getKey();
            Integer attended = entry.getValue();

            for (Lessons lesson : lessonsList) {
                if (lesson.getLesson().equals(lessonName)) {
                    totalLessons += lesson.getNumLessons();
                    attendedLessons += attended;
                    break;
                }
            }
        }



        double attendancePercentage = (double) attendedLessons / totalLessons * 100;
        return attendancePercentage;
    }

    */

}
