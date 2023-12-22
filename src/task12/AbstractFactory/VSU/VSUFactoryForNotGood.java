package task12.AbstractFactory.VSU;

import task12.AbstractFactory.Lesson;
import task12.AbstractFactory.Student;
import task12.AbstractFactory.UniversityFactory;

public class VSUFactoryForNotGood implements UniversityFactory {
    @Override
    public Student createStudent() {
        return new NotGoodStudent();
    }

    @Override
    public Lesson createLesson() {
        return new MathLesson();
    }
}
