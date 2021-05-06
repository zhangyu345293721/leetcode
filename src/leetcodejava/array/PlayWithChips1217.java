package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1217 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/play-with-chips
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 * <p>
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 * <p>
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * <p>
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 * <p>
 * 示例 1：
 * <p>
 * 输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 * 示例 2：
 * <p>
 * 输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PlayWithChips1217 {

    @Test
    public void playWithChipsTest() {
        int[] chips = {2, 2, 2, 3, 3};
        int steps = minCostToMoveChips2(chips);
        System.out.println(steps);
        Assert.assertEquals(steps, 2);
    }

    /**
     * 摆筹码
     *
     * @param chips 筹码下标
     * @return 最小距离
     */
    public int minCostToMoveChips(int[] chips) {
        int step = 0;
        for (int chip : chips) {
            if (chip % 2 == 1) {
                step++;
            }
        }
        return Math.min(step, chips.length - step);
    }

    /**
     * 摆筹码 (要么摆到奇数位置，要么摆到偶数位置，最后取最小值)
     *
     * @param chips 筹码下标
     * @return 最小距离
     */
    public int minCostToMoveChips2(int[] chips) {
        int step1 = 0;
        int step2 = 0;
        for (int chip : chips) {
            if (chip % 2 == 1) {
                step1++;
            } else {
                step2++;
            }
        }
        return Math.min(step1, step2);
    }
}
