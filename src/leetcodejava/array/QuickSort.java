package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void quickSortTest() {
        int[] nums = {6, 2, 1, 5, 4, 2, 8, 7, 5, 6};
        int[] result = quickSort(nums);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(nums[0], 1);
    }

    /**
     * 快速排序
     *
     * @param nums 数组
     */
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序
     *
     * @param nums  数字
     * @param left  下标left
     * @param right 下标right
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int q = partition(nums, left, right);
        quickSort(nums, left, q - 1);
        quickSort(nums, q + 1, right);
    }

    /**
     * 进行分区
     *
     * @param nums  数组
     * @param left  下标left
     * @param right 下标right
     * @return 分区点
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int rightMost = right;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] >= pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
            }
        }
        swap(nums, left, rightMost);
        return left;
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param nums 数组
     * @param i    位置i
     * @param j    位置j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
