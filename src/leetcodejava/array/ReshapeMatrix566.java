package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 重构数组
 *
 * @author: zhangyu
 */
public class ReshapeMatrix566 {
    @Test
    public void testReshapeMatrix() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};


        int r = 42;
        int c = 5;
        int[][] newArr = matrixReshape(arr, r, c);
        System.out.println(newArr);
    }

    /**
     * 重塑数组
     *
     * @param nums 数组
     * @param r    行
     * @param c    列
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        List<Integer> maxtrixList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                maxtrixList.add(nums[i][j]);
            }
        }
        int index = 0;
        if (maxtrixList.size() % r != 0 || maxtrixList.size() % c != 0 || c * r != maxtrixList.size()) {
            return nums;
        }

        int[][] newArr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newArr[i][j] = maxtrixList.get(index++);
            }
        }
        return newArr;
    }
}
