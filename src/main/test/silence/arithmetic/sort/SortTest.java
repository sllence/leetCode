package silence.arithmetic.sort;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    private int[] nums = {1, 3, 5, 2, 9, 3, 2};
    @Test
    public void bubbleSort() {
        BubbleSort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void quickSort() {
        QuickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}