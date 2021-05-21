package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This is the solution of No.496 problem in the LeetCode,
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
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(result);
        Assert.assertArrayEquals(result, new int[]{-1, 3, -1});
    }

    /**
     * 下一个数组中大的
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int[] res = new int[nums1.length];
        int i = 0;
        for (int num : nums1) {
            res[i++] = map.get(num);
        }
        return res;
    }


    /**
     * 下一个数组中大的
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : nums2) {
            stack.push(num);
        }
        for (int num : nums1) {
            Stack<Integer> temp = new Stack<>();
            boolean isFound = false;
            int max = -1;
            while (!stack.isEmpty() && !isFound) {
                int top = stack.pop();
                if (top > num) {
                    max = top;
                } else if (top == num) {
                    isFound = true;
                }
                temp.add(top);
            }
            result[i] = max;
            i++;
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
        return result;
    }
}
