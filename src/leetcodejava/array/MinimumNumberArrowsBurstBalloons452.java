package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.452 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinimumNumberArrowsBurstBalloons452 {

    @Test
    public void bitwiseANDNumbersRangeTest() {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int result = findMinArrowShots(points);
        System.out.println(result);
        Assert.assertEquals(result, 2);
    }

    /**
     * 查找最小箭头数量
     *
     * @param points 二维数组
     * @return 返回int
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length < 1) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int arrowCount = 1;
        int currentRight = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] temp = points[i];
            if (currentRight >= temp[0]) {
                if (currentRight > temp[1]) {
                    currentRight = temp[1];
                }
            } else {
                currentRight = temp[1];
                arrowCount++;
            }
        }
        return arrowCount;
    }
}
