package task8Exception;

public class CustomUnCheckedExMy {

    // Метод, который бросает наше непроверяемое исключение
    public static void throwUncheckedException() {
        // Выбрасываем исключение с пользовательским сообщением
        throw new UnCheckedExMy("This is a custom unchecked exception.");
    }
}
