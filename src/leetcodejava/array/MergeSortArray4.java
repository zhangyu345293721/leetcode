package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the solution of No. 4 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MergeSortArray4 {

    @Test
    public void testMergeArray() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double median=getMedian(nums1,nums2);
        System.out.println(median);
    }

    /**
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中间数
     */
    public double getMedian(int[] nums1, int nums2[]) {
        List<Integer> list = new ArrayList();
        for(int num1:nums1){
            list.add(num1);
        }
        for(int num2:nums2){
            list.add(num2);
        }
        Collections.sort(list);
        int length = list.size() ;
        if (length % 2 == 0) {
            return (list.get((length-1) / 2 ) + list.get((length -1)/ 2 + 1)) / 2.0;
        } else {
            return list.get((length-1) / 2);
        }
    }
}
