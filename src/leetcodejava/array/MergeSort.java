package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 *  归并排序
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
     * 归并排序
     *
     * @param nums  数组
     * @param left  位置l
     * @param right 位置r
     */
    public  void mergeSort(int[] nums, int left, int right) {
        // 退出条件
        if (left >= right) {
            return;
        }
        int part = left + (right - left) / 2;
        mergeSort(nums, left, part);
        mergeSort(nums, part + 1, right);
        merge(nums, left, part, right);
    }

    /**
     * 合并元素
     *
     * @param nums  数组
     * @param left  下标left
     * @param part  下标part
     * @param right 下标right
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
        // 如果有剩余元素，复制过去
        while (i <= part) {
            temp[k++] = nums[i++];
        }
        // 如果有剩余元素，复制过去
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        // 复制操作
        for (int num : temp) {
            nums[left++] = num;
        }
    }
}
