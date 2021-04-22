package leetcodejava.top100likedquestions;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.240 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Search2D240 {

    @Test
    public void search2DTest() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        boolean b = searchMatrix2(matrix, target);
        System.out.println(b);
        Assert.assertEquals(b, true);
    }

    /**
     * 输入数据，找出目标值
     *
     * @param matrix 二维数组n
     * @param target 目标值
     * @return 布尔值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * 输入数据，找出目标值
     *
     * @param matrix 二维数组n
     * @param target 目标值
     * @return 布尔值
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
