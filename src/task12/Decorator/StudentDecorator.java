package task12.Decorator;

public class StudentDecorator implements Student{
    Student student; //экземпляр разработчика

    public StudentDecorator(Student student) {
        this.student = student;
    }

    @Override
    public String makeLessons() {
        return student.makeLessons();
    }
}
