package TASK4;

public class MyClass extends TigerTwo {
    public static final String str = "Константная строка"; // если не статик то сколько экземпляров столько и констант

    public static Integer numOfCats(Integer a, Integer b){
        return a + b;
    }

    public static void print(){
        System.out.println("Второй, переопределённый метод не будет переопределяться тк не может");
    }

    public static void printNormal(){
        System.out.println("Обычный стактик метод");
    }


}
