package leetcodejava.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 67 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-binary/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindDuplicateNumber287 {
    @Test
    public void findDuplicateNumberTest() {
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

    /**
     * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     * 注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     * 即按照寻找链表环入口的思路来做
     *
     * @param nums 数组
     * @return int
     */
    public int findDuplicate3(int[] nums) {
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
