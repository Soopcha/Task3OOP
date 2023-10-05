package TASK4;

public class MyClass extends TigerTwo {
    public final String str = "Константная строка";

    public static Integer numOfCats(Integer a, Integer b){
        return a + b;
    }

    public static void print(){
        System.out.println("Второй, переопределённый метод");
    }

    public static void printNormal(){
        System.out.println("Обычный стактик метод");
    }


}
