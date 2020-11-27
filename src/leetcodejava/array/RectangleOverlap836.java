package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 836 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/rectangle-overlap
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false 
 * 提示：
 * <p>
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 * x 轴默认指向右，y 轴默认指向上。
 * 你可以仅考虑矩形是正放的情况。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RectangleOverlap836 {

    @Test
    public void rectangleOverlapTest() {
        int[] rec1 = {5, 15, 8, 18};
        int[] rec2 = {0, 3, 7, 9};
        boolean flag = isRectangleOverlap(rec1, rec2);
        System.out.println(flag);
    }

    /**
     * 判断矩形是否重叠
     *
     * @param rec1 矩形1
     * @param rec2 矩形2
     * @return 布尔值
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x11 = rec1[0], y11 = rec1[1], x12 = rec1[2], y12 = rec1[3];
        int x21 = rec2[0], y21 = rec2[1], x22 = rec2[2], y22 = rec2[3];
        boolean yFlag = !(y21 >= y12 || y22 <= y11);
        boolean xFlag = !(x21 >= x12 || x22 <= x11);
        return xFlag && yFlag;
    }
}
