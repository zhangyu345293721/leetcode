package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is the solution of No.448 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindDisappearedNumbers448 {
    @Test
    public void findDisappearedNumbersTest() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result);
        Assert.assertEquals(result.size(), 2);
    }

    /**
     * 找失去数字
     *
     * @param nums 数组
     * @return 链表
     */
    private List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 找失去数字
     *
     * @param nums 数组
     * @return 链表
     */
    private List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        for (int num : nums) {    // 这是一种转换的技巧算法，非常实用，但是难以想到
            int idx = Math.abs(num) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] > 0) {
                res.add(i);
            }
        }
        return res;
    }
}
