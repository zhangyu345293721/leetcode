package leetcode.java.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 合并数组
 *
 * @author: zhangyu
 */
public class MergeArray88 {

    /**
     * 按照要求合并两个数组
     *
     * @param nums1 数组1
     * @param m     开始位置
     * @param nums2 数组2
     * @param n     开始位置
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < 1 || nums1 == null) {
            return null;
        }
        if (nums2.length < 1 || nums2 == null) {
            return null;
        }
        int[] arr = new int[nums1.length];
        int index = 0;
        int i = 0;
        int j = 0;
        // 按照顺序插入到另外一个链表中
        while ((i < m) && (j < n)) {
            if (nums1[i] <= nums2[j]) {
                arr[index] = nums1[i];
                i++;
                index++;
            } else {
                arr[index] = nums2[j];
                j++;
                index++;
            }
        }
        // 如果没插入完整继续
        while (i < m) {
            arr[index] = nums1[i];
            i++;
            index++;
        }
        // 如果没插入完整继续
        while (j < n) {
            arr[index] = nums2[j];
            j++;
            index++;
        }
        return arr;
    }

    /**
     * 合并数组
     *
     * @param nums1 输入数组1
     * @param m     个数1
     * @param nums2 输入数字2
     * @param n     个数2
     * @return 返回数组
     */
    public int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m] = nums2[i];
            m++;
        }
        Arrays.sort(nums1);
        return nums1;
    }

    @Test
    public void testMergeArray() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int[] arr = merge2(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(arr));
    }
}
