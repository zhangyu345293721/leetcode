package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 77 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/combinations
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Combinations77 {

    @Test
    public void combinationsTest() {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
        Assert.assertEquals(result.size(), 6);
    }

    /**
     * 进行排列组合
     *
     * @param n n个数字
     * @param k 选k个数字
     * @return list
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>(); // 用于存储 总结果集
        List<Integer> temp = new ArrayList<>(); // 用于存储 当前结果
        search(n, k, 1, temp, result);
        return result;
    }

    /**
     * 保证在当前循环中，不会重复遍历之前遍历过的数字
     * n - (k - path.size()) + 1 表示当前循环，起点所能达到的最大的数(保证最后一个数字加入时，
     * 正好能组成长度为k的结果)
     *
     * @param n      数字范围
     * @param k      长度
     * @param num    数字
     * @param temp   路径
     * @param result 结果
     */
    private void search(int n, int k, int num, List<Integer> temp, List<List<Integer>> result) {
        // 长度合适，增加当前结果，结束本轮递归
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = num; i <= n - (k - temp.size()) + 1; i++) {
            // 将新元素添加至尾部，照应后面的处理
            temp.add(i);
            search(n, k, i + 1, temp, result);
            // 移除最后添加进去的元素
            temp.remove(temp.size() - 1);
        }
    }
}
