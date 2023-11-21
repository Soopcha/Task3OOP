package task8Exception;

public class MainEx {

    public static void main(String[] args) {
        try {
            CustomCheckedExMy.throwCheckedException();
        } catch (CheckedExMy e) {
            System.out.println("Caught MainException: " + e.getMessage());
        }


        System.out.println();
        System.out.println();


        // Вызов метода, который бросает наше непроверяемое исключение
        //CustomUnCheckedExMy.throwUncheckedException();
        System.out.println();
        System.out.println();


        try {
            throw new RuntimeException(" My manual exception");
        } catch (RuntimeException e) {
            System.out.println("Caught Exception" + e.getMessage());
        }




        //TryCatchFinally пример

        try {
            meMetod();
        } catch (Exception e) {
            System.err.println("Caught an exception: " + e.getMessage());
        } finally {
            // Блок finally будет выполнен в любом случае, даже если исключение было или не было брошено
            System.out.println("Finally block is executed."); //финальный блок выполненен
        }




        System.out.println();
        System.out.println();
        System.out.println();

        //Пример использования блока try и finally без перехвата исключения:
        /*
        try {
            // Некоторый код, который может вызвать исключение
            performOperation();
        } finally {
            // Блок finally будет выполнен в любом случае, даже если произошло исключение
            System.out.println("Finally block is executed.");
        }

         */





        //обработка нескольких исключений
        try {
            // Некоторый код, который может вызвать исключение
            performOperations();
        } catch (ArithmeticException | NullPointerException e) {
            // Обработка исключений ArithmeticException и NullPointerException
            System.out.println("Caught an exception: " + e.getMessage());
        } catch (Exception e) {
            // Обработка других исключений
            System.out.println("Caught an exception: " + e.getMessage());
        }


    }

    // Метод, который может бросить различные исключения
    public static void performOperations() {
        int result = 5/0; // вызываем метод, который делит на ноль
        String str = null;
        int length = str.length(); // вызываем метод у null, что вызовет NullPointerException
    }



    public static void performOperation() {
        // что-то произошло и пришлось выбросить исключение
        throw new RuntimeException("An error occurred during the operation.");//Во время операции произошла ошибка
    }

    public static void meMetod() throws Exception {
        // что-то произошло и пришлось выбросить исключение
        throw new Exception("An error occurred during the operation.");
    }





}
