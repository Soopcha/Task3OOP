package task12.AbstractFactory.VSU;

import task12.AbstractFactory.Lesson;
import task12.AbstractFactory.Student;
import task12.AbstractFactory.UniversityFactory;

public class VSUFactoryForGoodAndExcellent implements UniversityFactory {
    @Override
    public Student createStudent() {
        return new ExcellentAndGoodStudent();

    }

    @Override
    public Lesson createLesson() {
        return new MathLesson();
    }
}
