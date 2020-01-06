package leetcode.tree;

import org.junit.Test;


/**
 * 这个题目在leetcode被编为hard类型，我这种做法居然还有这么高的效率，有点不太相信
 * * Runtime: 28 ms, faster than 86.93% of Java online submissions for Median of Two Sorted Arrays.
 *
 * @author zhangyu
 **/

public class FindMediaTwoSortArray {
    @Test
    public void testFindMediaTwoSortArray() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double media = getMedian(nums1, nums2);
        System.out.println(media);
    }

    /**
     * 中间值
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 值
     */
    private double getMedian(int[] nums1, int[] nums2) {
        double media = 0;
        int[] newArr = mergeSortedArray(nums1, nums2);
        if (newArr.length % 2 == 0) {
            int length = newArr.length;
            media = (newArr[(length - 1) / 2] + newArr[(length - 1) / 2 + 1]) / 2.0;
        } else {
            media = newArr[(newArr.length - 1) / 2];
        }
        return media;
    }

    /**
     * 合并有序数组
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 新数组
     */
    public int[] mergeSortedArray(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] newArr = new int[nums1Length + nums2Length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1Length && j < nums2Length) {
            if (nums1[i] < nums2[j]) {
                newArr[index++] = nums1[i];
                i++;
            } else {
                newArr[index++] = nums2[j];
                j++;
            }
        }
        while (i < nums1Length) {
            newArr[index++] = nums1[i];
            i++;
        }
        while (j < nums2Length) {
            newArr[index++] = nums2[j];
            j++;
        }
        return newArr;
    }
}
