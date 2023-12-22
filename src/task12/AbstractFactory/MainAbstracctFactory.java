package task12.AbstractFactory;

import task12.AbstractFactory.VSU.NotGoodStudent;
import task12.AbstractFactory.VSU.VSUFactoryForGoodAndExcellent;
import task12.AbstractFactory.VSU.VSUFactoryForNotGood;

//группы студенты занятия посещаемость
//Паттерн "Абстрактная фабрика" (Abstract Factory) относится к классу
// порождающих паттернов проектирования и предоставляет интерфейс для
// создания семейств взаимосвязанных объектов, не специфицируя их конкретных
// классов. Он позволяет создавать объекты без указания их конкретных типов,
// что делает систему независимой от способа создания, композиции и
// представления её компонентов.
public class MainAbstracctFactory {
    public static void main(String[] args) {
        UniversityFactory unFactoryVSUForGoodAndExcellent = new VSUFactoryForGoodAndExcellent();
        UniversityFactory unFactoryVSUForNotGood = new VSUFactoryForNotGood();

        Student notGoodStudent = unFactoryVSUForNotGood.createStudent();
        Student goodAndExcellentStudent = unFactoryVSUForGoodAndExcellent.createStudent();

        Lesson math = unFactoryVSUForNotGood.createLesson();

        notGoodStudent.attendClass();
        goodAndExcellentStudent.attendClass();
        math.conductLesson();

    }
}



