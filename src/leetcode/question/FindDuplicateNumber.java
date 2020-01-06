package leetcode.question;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyu
 **/


public class FindDuplicateNumber {
    @Test
    public void testFindDuplicateNumber() {
        int arr[] = {1, 3, 4, 2, 2};
        int duplicateNumber = findDuplicateNumber2(arr);
        System.out.println(duplicateNumber);
    }

    /**
     * 重复数字
     *
     * @param nums 数组
     * @return int
     */
    private int findDuplicateNumber1(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 重复数字
     *
     * @param nums 数组
     * @return int
     */
    private int findDuplicateNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return num;
            }
        }
        return -1;
    }
}
