package java.array;

import org.junit.Test;

/**
 * 结果矩阵中基数值个数
 *
 * @author: zhangyu
 */
public class CellsOddValues1252 {

    @Test
    public void testCellsOddValues() {
        int n = 2;
        int m = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        int num = oddCells(n, m, indices);
        System.out.println(num);
    }

    /**
     * 奇数个数
     *
     * @param n       n行
     * @param m       m列
     * @param indices 引导数组
     * @return 奇数个数
     */
    public int oddCells(int n, int m, int[][] indices) {
        int[][] cells = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int[] index = indices[i];
            int row = index[0];
            int col = index[1];
            for (int c = 0; c < cells[row].length; c++) {
                cells[row][c] += 1;
            }
            for (int c = 0; c < cells.length; c++) {
                cells[c][col] += 1;
            }
        }
        int number = getOddNumbers(cells);
        return number;

    }

    /**
     * 获取奇数的个数
     *
     * @param cells 二维数组
     * @return 奇数
     */
    private int getOddNumbers(int[][] cells) {
        int count = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
