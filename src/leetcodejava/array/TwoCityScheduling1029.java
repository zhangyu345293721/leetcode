package leetcodejava.array;

import org.junit.Test;
import java.util.Arrays;

/**
 * 两个城市一半的人旅行
 *
 * @author: zhangyu
 */
public class TwoCityScheduling1029 {
    @Test
    public void testTwoCityScheduling() {
        int[][] arr = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        int sum = twoCitySchedCost(arr);
        System.out.println(sum);

    }

    /**
     * 计算两个城市消费
     *
     * @param costs 二维数组
     * @return 消费
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            sum += costs[i][1];
        }
        return sum;
    }
}
