package leetcodejava.array;

import org.junit.Test;

/**
 * 矩阵重叠
 *
 * @author: zhangyu
 */
public class RectangleOverlap836 {

    @Test
    public void testRectangleOverlap() {
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
