package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the solution of No. 216 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combination-sum-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CombinationSum216 {

    @Test
    public void combinationSumTest() {
        int k = 3;
        int n = 7;
        List<List<Integer>> lists = combinationSum(k, n);
        System.out.println(lists);
    }

    /**
     * 寻找k个数的和为n
     *
     * @param k k个数
     * @param n 选则数的和
     * @return 寻找k数和为n
     */
    public List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(k, n, result, temp, 1);
        return result;
    }

    /**
     * 计算帮助类
     *
     * @param k      k个数
     * @param target 目标值
     * @param result 结果链表
     * @param temp   临时链表
     * @param num    数字
     */
    private void helper(int k, int target, List<List<Integer>> result, List<Integer> temp, int num) {
        for (int i = num; i < 10; i++) {
            if (i > target) {
                break;
            }
            temp.add(i);
            if (target == i) {
                if (k == temp.size()) {
                    result.add(new ArrayList<>(temp));
                }
            } else {
                helper(k, target - i, result, temp, i + 1);
            }
            temp.remove(temp.size() - 1);
        }
    }
}
