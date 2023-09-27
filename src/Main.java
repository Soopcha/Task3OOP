public class Main {
    public static void main(String[] args) {
        Animal animalTurtles = new Turtles("male",1,"Крис","Белая черепаха");
        animalTurtles.Print();



        Cats cats = new Cats("Лиса");
        Tigers tigers = new Tigers("Тигр Веник", 123);
        Cats catsTiger = new Tigers("Саша",234);

        cats.Print();
        tigers.Print();
        catsTiger.Print();
    }
}