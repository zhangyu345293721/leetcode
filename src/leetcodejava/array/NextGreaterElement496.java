package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No.945 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/next-greater-element-i
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class NextGreaterElement496 {

    @Test
    public void nextGreaterElementTest() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] array = nextGreaterElement(nums1, nums2);
        System.out.println(array);
    }

    /**
     * 下一个数组中大的
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] newArr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int element = getNumber(nums2, nums1[i]);
            newArr[i] = element;
        }
        return newArr;
    }

    /**
     * 找出nums2中有没有元素大于num
     *
     * @param nums2 数组num2
     * @param num   数字
     * @return 返回数
     */
    private int getNumber(int[] nums2, int num) {
        int index = getIndex(nums2, num);
        if (index == nums2.length - 1) {
            return -1;
        }
        for (int i = index + 1; i < nums2.length; i++) {
            if (nums2[i] > num) {
                return nums2[i];
            }
        }
        return -1;
    }

    /**
     * 获取树
     *
     * @param nums2 数组2
     * @param num   数字
     * @return 下标
     */
    private int getIndex(int[] nums2, int num) {
        for (int i = 0; i < nums2.length; i++) {
            if (num == nums2[i]) {
                return i;
            }
        }
        return -1;
    }
}
