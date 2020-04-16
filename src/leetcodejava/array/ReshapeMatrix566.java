package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 566 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reshape-the-matrix
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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
