package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 128 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/longest-consecutive-sequence
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongestConsecutiveSequence128 {
    @Test
    public void longestConsecutiveSequenceTest() {
        int[] nums = {12, 13, 1, 4, 5, 6};
        int result = longestConsecutive(nums);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 连续数的长度
     *
     * @param nums 数组
     * @return 连续数组长度
     */
    private int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int maxLength = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                count++;
            } else {
                if (nums[i] != nums[i + 1]) {
                    count = 1;
                }
            }
            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }

    /**
     * 最长连续传
     *
     * @param nums 数组
     * @return 最大长度
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        Set<Integer> numSet = new HashSet();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
