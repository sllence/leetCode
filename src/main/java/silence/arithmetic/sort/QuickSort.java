package silence.arithmetic.sort;

import java.util.Stack;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] numbers) {
        if (numbers.length < 2) {
            return;
        }
        quickSortStack(numbers, 0, numbers.length - 1);
    }

    private static void quickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }
        int pat = partition2(numbers, low, high);
        quickSort(numbers, low, pat - 1);
        quickSort(numbers, pat + 1, high);

    }

    private static void quickSortStack(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }
        Stack<Integer> stack =new Stack<Integer>();
        stack.push(high);
        stack.push(low);
        while (!stack.empty()){
            low = stack.pop();
            high = stack.pop();
            if(low<high){
                int pat = partition2(numbers, low, high);
                stack.push(high);
                stack.push(pat + 1);
                stack.push(pat - 1);
                stack.push(low);
            }
        }
    }

    private static int partition(int[] numbers, int low, int high) {
        int pivot = numbers[low];
        int temp;
        while (low < high) {
            while (low < high) {
                if (numbers[high] < pivot) {
                    temp = numbers[high];
                    numbers[high] = numbers[low];
                    numbers[low] = temp;
                    break;
                } else {
                    high--;
                }
            }
            while (low < high) {
                if (numbers[low] >= pivot) {
                    temp = numbers[high];
                    numbers[high] = numbers[low];
                    numbers[low] = temp;
                    break;
                } else {
                    low++;
                }
            }
        }
        return low;
    }

    private static int partition2(int[] numbers, int low, int high) {
        int pivot = numbers[low];
        int temp;
        int i = low + 1;
        while (low < high) {
            if (numbers[i] > pivot) {
                temp = numbers[high];
                numbers[high] = numbers[i];
                numbers[i] = temp;
                high--;
            } else {
                temp = numbers[i];
                numbers[i] = numbers[low];
                numbers[low] = temp;
                low++;
                i++;
            }
        }
        return low;
    }
}
