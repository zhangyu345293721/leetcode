package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 归并排序
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
     * @param nums 数组
     * @param l    位置l
     * @param r    位置r
     */
    public void mergeSort(int[] nums, int l, int r) {
        // 退出条件
        if (l >= r) {
            return;
        }
        int q = l + (r - l) / 2;
        mergeSort(nums, l, q);
        mergeSort(nums, q + 1, r);
        merge(nums, l, q, r);
    }

    /**
     * 合并元素
     *
     * @param nums 数组
     * @param l    下标l
     * @param q    下标q
     * @param r    下标r
     */
    private void merge(int[] nums, int l, int q, int r) {
        int temp[] = new int[r - l + 1];
        int i = l;
        int j = q + 1;
        int k = 0;
        while (i <= q && j <= r) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= q) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (int num : temp) {
            nums[l++] = num;
        }
    }
}
