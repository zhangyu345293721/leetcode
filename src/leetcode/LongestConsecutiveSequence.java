package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LongestConsecutiveSequence
 * @Description: TOTO
 * @date 2018/11/28 15:25
 **/


public class LongestConsecutiveSequence {
    @Test
    public void fun() {
        //int[] nums = {100, 4, 200, 1, 3, 2, 7, 8};
        // int[] nums = {0, -1};
        int nums[] = {1, 2, 3, 3, 4};
        int maxLength = longestConsecutive(nums);
        System.out.println(maxLength);
    }

    // 连续数的长度
    private int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        int maxLength = 1;
        int count = 1;
        // 再遍历整个数组;
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
