public class ываыва {
    private static int comparisons = 0; // Переменная для подсчета сравнений

    // Метод для обмена элементов массива
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Метод для разделения массива и выполнения сортировки
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Выбираем опорный элемент
        int i = (low - 1); // Индекс меньшего элемента
        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше, чем опорный
            comparisons++; // Увеличиваем счетчик сравнений
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Метод для рекурсивной сортировки массива
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Метод для вызова быстрой сортировки с подсчетом количества сравнений
    public static void sortWithComparisons(int[] arr) {
        comparisons = 0; // Сбрасываем счетчик сравнений
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Количество сравнений: " + comparisons);
    }

    public static void main(String[] args) {
        int[] arr = {18, 2, 12, 15, 4, 20, 10, 13, 7, 3, 19, 5, 11, 1, 6, 8, 14, 16, 9, 17};
        sortWithComparisons(arr);
    }

}
