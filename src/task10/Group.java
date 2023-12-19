package task10;

import java.util.List;
import java.util.Map;

public class Group {
    //нужен класс функций обычнй
    // класс групп список студентов и их рассписание
    // расписание где связь группы и уроков хеш мап группа список предметов для группы

    private Integer numGroup;
    private List<Student> studentList;
    private List<Lessons> lessonsList;

    private void addLessons(String nameLesson, Integer numLessons){
        lessonsList.add(new Lessons(numLessons,nameLesson));
    }

    private void addStudent(String name,Map<String,Integer> attendanceMap){
        studentList.add(new Student(name,attendanceMap));
    }
    public Group(Integer numGroup, List<Student> studentList, List<Lessons> lessonsList) {
        this.numGroup = numGroup;
        this.studentList = studentList;
        this.lessonsList = lessonsList;
    }

    public Integer getNumGroup() {
        return numGroup;
    }

    public void setNumGroup(Integer numGroup) {
        this.numGroup = numGroup;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Lessons> getLessonsList() {
        return lessonsList;
    }

    public void setLessonsList(List<Lessons> lessonsList) {
        this.lessonsList = lessonsList;
    }
}
