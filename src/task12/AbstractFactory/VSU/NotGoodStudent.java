package task12.AbstractFactory.VSU;

import task12.AbstractFactory.Student;

public class NotGoodStudent implements Student {
    @Override
    public void attendClass() {
        System.out.println("Ученик троечник часто прогуливает");
    }
}
