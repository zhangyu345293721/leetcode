package leetcodejava.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyu
 **/


public class LongestConsecutiveSequence128 {
    @Test
    public void testLongestConsecutiveSequence() {
        int[] nums = {12, 13, 1, 4, 5, 6};
        int maxLength = longestConsecutive2(nums);
        System.out.println(maxLength);
    }


    /**
     * 连续数的长度
     *
     * @param nums 数组
     * @return 连续数组长度
     */
    private int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int maxLength = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                count++;
            } else {
                if (nums[i] != nums[i + 1])
                    count = 1;
            }
            if (maxLength < count)
                maxLength = count;
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
        Set<Integer> numSet = new HashSet<Integer>();
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
