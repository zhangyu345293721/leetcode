package leetcodejava.slidewindow;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No.Offer57 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TargetSumOffer57 {

    @Test
    public void offer57Test() {
        int target = 9;
        int[][] result = findContinuousSequence(target);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(result.length, 2);
    }

    /**
     * 连续和
     *
     * @param target 目标值
     * @return 结果集
     */
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        List<Integer> temp = new LinkedList<>();
        int i = 1;
        while (i < target) {
            if (sum < target) {
                temp.add(i);
                sum += i;
                i++;
            } else if (sum == target) {
                result.add(new ArrayList<>(temp));
                temp.add(i);
                sum += i;
                i++;
            } else {
                sum -= temp.remove(0);
            }
        }
        int size = result.size();
        int res[][] = new int[size][];
        int index = 0;
        for (List<Integer> e : result) {
            int len = e.size();
            int[] pair = new int[len];
            for (int k = 0; k < len; k++) {
                pair[k] = e.get(k);
            }
            res[index++] = pair;
        }
        return res;
    }
}
