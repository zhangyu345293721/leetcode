package leetcodejava.array;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * This is the solution of No. 912 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sort-an-array
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SortArray912 {
    @Test
    public void testSortArray() {
        int[] nums = {4, 1, 3, 4, 5, 7};
        int[] arr = sortArray(nums);
        System.out.println(arr);
    }

    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int num : nums) {
            queue.add(num);
        }
        int[] array = new int[nums.length];
        int index = 0;
        while (queue.iterator().hasNext()) {
            array[index++] = queue.poll();
        }
        return array;
    }
}
