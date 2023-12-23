package task12.Decorator;

public class StudenStarosta extends StudentDecorator{
    public StudenStarosta(Student student) {
        super(student);
    }

    public String sendTaskStudent(){
        return "Нужно сделать отчёт.";
    }

    @Override
    public String makeLessons() {
        return super.makeLessons() + sendTaskStudent();
    }
}
