package task8Exception;

public class CustomCheckedExMy {

    // Метод, который бросает наше исключение
    public static void throwCheckedException() throws CheckedExMy {
        // Выбрасываем исключение с сообщением
        throw new CheckedExMy("This is a custom checked exception.");
    }
}
