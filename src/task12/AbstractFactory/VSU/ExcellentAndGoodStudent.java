package task12.AbstractFactory.VSU;

import task12.AbstractFactory.Student;

public class ExcellentAndGoodStudent implements Student {
    @Override
    public void attendClass() {
        System.out.println("Студент отличник или хорошист посещает пары часто");
    }
}
