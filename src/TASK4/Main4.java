package TASK4;

public class Main4 {
    public static void main(String[] args) {


        Integer a = 123;
        Integer b = 123;
        System.out.println(MyClass.numOfCats(a,b));

        MyClass.print(); // можно вызывать без создания экземпляра класса
        //никакого нет override
        TigerTwo.print();
        MyClass.printNormal();

    }

    // по умолчанию любой метод в джава вертуальный

}
