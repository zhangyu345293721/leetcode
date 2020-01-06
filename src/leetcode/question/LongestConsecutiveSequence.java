package leetcode.question;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangyu
 **/


public class LongestConsecutiveSequence {
    @Test
    public void testLongestConsecutiveSequence() {
        int nums[] = {1, 2, 3, 3, 4};
        int maxLength = longestConsecutive(nums);
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
}
