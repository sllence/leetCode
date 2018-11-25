package silence.arithmetic.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] numbers) {
        if (numbers.length < 2) {
            return;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
    }
}
