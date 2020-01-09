package java.array;

import org.junit.Test;

/**
 * 玩筹码
 *
 * @author: zhangyu
 */
public class PlaywithChips1217 {

    @Test
    public void testPlayWithChips() {
        int[] chips = {2, 2, 2, 3, 3};
        int steps = minCostToMoveChips2(chips);
        System.out.println(steps);
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
