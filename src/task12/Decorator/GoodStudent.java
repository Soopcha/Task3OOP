package task12.Decorator;

public class GoodStudent extends StudentDecorator{
    public GoodStudent(Student student) {
        super(student);
    }
    public String makeGoodExam(){
        return "Хорошо написанный экзамен получился. ";
    }

    @Override
    public String makeLessons() {
        return super.makeLessons() + makeGoodExam();
    }
}
