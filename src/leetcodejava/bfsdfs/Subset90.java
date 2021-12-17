package leetcodejava.bfsdfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.90 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/subsets-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Subset90 {

    @Test
    public void subsetTest() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsets2(nums);
        System.out.println(result);
        Assert.assertEquals(result.size(), 6);
    }

    /**
     * 数组生成所有的子集
     *
     * @param nums 数组
     * @return 链表
     */
    public List<List<Integer>> subsets2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);      // 排序后便于去重
        searchHelper(nums, result, nums.length, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    /**
     * 深度优先遍历
     *
     * @param nums   数组
     * @param result 结果集合
     * @param len    数组长度
     * @param index  数组下标
     * @param temp   临时链表
     */
    private void searchHelper(int[] nums, Set<List<Integer>> result, int len, int index, List<Integer> temp) {
        if (index == len) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 不选该数
        searchHelper(nums, result, len, index + 1, temp);
        temp.add(nums[index]);
        // 选择该数
        searchHelper(nums, result, len, index + 1, temp);
        temp.remove(temp.size() - 1);
    }
}
