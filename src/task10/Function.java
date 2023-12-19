package task10;

import java.util.List;
import java.util.Map;

public class Function {

    public static void checkAttendance(Student student, Group group) {
        Map<String,Integer> attendanceMap = student.getAttendanceMap();
        List<Lessons> lessonsList = group.getLessonsList();

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

    public static double calculateAttendancePercentage(Student student, Group group) { //считает проуннт посещаемости
        Map<String,Integer> attendanceMap = student.getAttendanceMap();
        List<Lessons> lessonsList = group.getLessonsList();
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
