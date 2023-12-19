package task10;

import java.util.ArrayList;
import java.util.List;

public class Inquiry { //класс расписание

   private List<Lessons> lessonsList = new ArrayList<>();

    public Inquiry(List<Lessons> lessonsList) {
        this.lessonsList = lessonsList;
    }

    public void addLessons (Lessons lessons){
        lessonsList.add(lessons);
    }

    public List<Lessons> getLessonsList() {
        return lessonsList;
    }

    public void setLessonsList(List<Lessons> lessonsList) {
        this.lessonsList = lessonsList;
    }
}
