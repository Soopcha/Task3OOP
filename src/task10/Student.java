package task10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private Integer groupNumber;
    private Map<String,Integer> attendanceMap;
    private List<Lessons> lessonsList;

    public Map<String, Integer> getAttendanceMap() {
        return attendanceMap;
    }

    public void setAttendanceMap(Map<String, Integer> attendanceMap) {
        this.attendanceMap = attendanceMap;
    }

    public List<Lessons> getLessonsList() {
        return lessonsList;
    }

    public void setLessonsList(List<Lessons> lessonsList) {
        this.lessonsList = lessonsList;
    }

    public Student(String name, Integer groupNumber, Map<String, Integer> attendanceMap, List<Lessons> lessonsList) {
        this.name = name;
        this.groupNumber = groupNumber;
        this.attendanceMap = attendanceMap;
        this.lessonsList=lessonsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }


    public void checkAttendance() {
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

}
