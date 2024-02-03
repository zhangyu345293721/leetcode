package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 *  merge sort
 *  1）mege sort, first split array to many array
 *  2）merge many array to one sort array
 */
public class MergeSort {

    @Test
    public void mergeSortTest() {
        int[] nums = {4, 2, 1, 4, 6, 7, 3};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(nums);
        Assert.assertEquals(nums[0], 1);
    }

     /**
     * binary sort
     *
     * @param nums  array
     * @param left  index left
     * @param right index right
     */
    public  void mergeSort(int[] nums, int left, int right) {
        // return
        if (left >= right) {
            return;
        }
        int part = left + (right - left) / 2;
        mergeSort(nums, left, part);
        mergeSort(nums, part + 1, right);
        merge(nums, left, part, right);
    }

    /**
     * merge numbers to array
     *
     * @param nums  array
     * @param left  index left
     * @param part  index part
     * @param right index right
     */
    private void merge(int[] nums, int left, int part, int right) {
        int temp[] = new int[right - left + 1];
        int i = left;
        int j = part + 1;
        int k = 0;
        while (i <= part && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // copy left element
        while (i <= part) {
            temp[k++] = nums[i++];
        }
        // copy left element
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        // copy temp array numbers to nums
        for (int num : temp) {
            nums[left++] = num;
        }
    }
}
