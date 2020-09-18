package leetcodejava.array;

import org.junit.Test;

import java.util.*;


/**
 * This is the solution of No.47 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/permutations-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 * @date: 2020/9/18
 */
public class Permutations47 {

    @Test
    public void permutationsTest() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }

    /**
     * 深度回溯，全排列
     *
     * @param nums 数组
     * @return 结果链表
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, result, temp, 0);
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param num   数组
     * @param res   结果链表
     * @param temp  临时链表（临时链表长度等于数组长度就加入到结果链表）
     * @param index 下标
     */
    public void helper(int[] num, List<List<Integer>> res, List<Integer> temp, int index) {
        if (index == num.length) {
            res.add(new ArrayList(temp));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < num.length; i++) {
            if (set.contains(num[i])) {
                continue;
            }
            set.add(num[i]);
            temp.add(num[i]);
            swap(num, index, i);
            helper(num, res, temp, index + 1);
            temp.remove(index);
            swap(num, index, i);
        }
    }

    /**
     * 交换数组中两个数的位置
     *
     * @param num 数组
     * @param i   位置i
     * @param j   位置j
     */
    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
