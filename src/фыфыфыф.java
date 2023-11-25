import java.util.Arrays;

public class фыфыфыф {

        private static int comparisonCount = 0;

        public static void main(String[] args) {
            int[] arr = {18, 2, 12, 15, 4, 20, 10, 13, 7, 3, 19, 5, 11, 1, 6, 8, 14, 16, 9, 17};
            quickSort(arr, 0, arr.length - 1);

            System.out.println("Отсортированный массив: " + Arrays.toString(arr));
            System.out.println("Количество сравнений: " + comparisonCount);
        }

        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int partitionIndex = partition(arr, low, high);

                quickSort(arr, low, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, high);
            }
        }

        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                comparisonCount++; // Увеличиваем счетчик сравнений
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }

            swap(arr, i + 1, high);
            return i + 1;
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}
