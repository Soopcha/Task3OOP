package task10;

public class Lessons {
    private Integer numLessons;
    private String lesson;

    public Integer getNumLessons() {
        return numLessons;
    }

    public void setNumLessons(Integer numLessons) {
        this.numLessons = numLessons;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }


    public Lessons(Integer numLessons, String lessons) {
        this.numLessons = numLessons;
        this.lesson = lessons;
    }
}
