package task12.AbstractFactory.VSU;

import task12.AbstractFactory.Lesson;

public class MathLesson implements Lesson {
    @Override
    public void conductLesson() {
        System.out.println("Пары математики каждые чт, ср");
    }
}
