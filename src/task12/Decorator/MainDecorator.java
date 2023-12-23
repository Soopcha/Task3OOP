package task12.Decorator;
// Декоратор
// Денамическое добавление обязанносте обьекту

//Паттерн "Декоратор" предоставляет гибкую альтернативу наследованию
// для расширения функциональности класса. Вместо того чтобы создавать
// подклассы для каждого варианта поведения, вы можете использовать
// декораторы для обертывания объекта и добавления или изменения его функциональности
public class MainDecorator {
    public static void main(String[] args) {
        Student student = new GoodStudent(new StudentVSU());
        System.out.println(student.makeLessons());


        Student student2 = new StudenStarosta(new GoodStudent(new StudentVSU()));
        System.out.println(student2.makeLessons());

        Student student3 = new StudenStarosta(new StudentVSU());
        System.out.println(student3.makeLessons());
    }
}
