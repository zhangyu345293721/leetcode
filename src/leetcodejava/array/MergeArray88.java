package leetcodejava.array;

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

    /**
     * 对数组进行合并排序
     *
     * @param A 数组A
     * @param m 开始下标m
     * @param B 数组b
     * @param n 开始下标n
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        for (int num2 : B) {
            A[m++] = num2;
        }
        Arrays.sort(A);
    }
    @Test
    public void testMergeArray() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge2(nums1, 3, nums2, 3);

    }
}
