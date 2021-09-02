package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No.120 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/triangle
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Triangle120 {

    @Test
    public void triangleTest() {
        List<Integer> list1 = new ArrayList(Arrays.asList(2));
        List<Integer> list2 = new ArrayList(Arrays.asList(3, 4));
        List<Integer> list3 = new ArrayList(Arrays.asList(6, 5, 7));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));
        List<List<Integer>> list = new ArrayList(Arrays.asList(list1, list2, list3, list4));
        int result = minimumTotal(list);
        Assert.assertEquals(result, 11);
    }

    /**
     * 三角形最小路径
     *
     * @param triangle 三角形二维链表
     * @return 最小路径
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 加1可以不用初始化最后一层
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 三角形最小路径
     *
     * @param triangle 三角形二维链表
     * @return 最小路径
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
