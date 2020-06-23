package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 88 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-sorted-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MergeArray88 {

    /**
     * 对数组进行合并排序
     *
     * @param nums1 数组1
     * @param m     开始下标m
     * @param nums2 数组2
     * @param n     开始下标n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int num2 : nums2) {
            nums1[m++] = num2;
        }
        Arrays.sort(nums1);
    }

    /**
     * 对数组进行合并排序
     *
     * @param nums1 数组nums1
     * @param m     开始下标m
     * @param nums2 数组nums2
     * @param n     开始下标n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * 按照要求合并两个数组
     *
     * @param nums1 数组1
     * @param m     开始位置
     * @param nums2 数组2
     * @param n     开始位置
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[nums1.length];
        int index = 0;
        int i = 0;
        int j = 0;
        // 按照顺序插入到另外一个链表中
        while (i < m && j < n) {
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


    @Test
    public void testMergeArray() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
