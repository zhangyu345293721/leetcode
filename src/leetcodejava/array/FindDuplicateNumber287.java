package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 287 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-the-duplicate-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindDuplicateNumber287 {
    @Test
    public void findDuplicateNumberTest() {
        int nums[] = {1, 3, 4, 2, 2};
        int duplicateNumber = findDuplicateNumber3(nums);
        Assert.assertEquals(duplicateNumber, 2);
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
     * @return num
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
     * 快慢指针方式找出重复的数
     *
     * @param nums 数组
     * @return num
     */
    public int findDuplicateNumber3(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        // 找出里面的环
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 另外一只兔子从原点出发，一定会在重复点出和另外一个乌龟相遇
        int slow2 = 0;
        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow2;
    }
}
