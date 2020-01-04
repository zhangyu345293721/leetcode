package array;

import org.junit.Test;

/**
 * 结果矩阵中基数值个数
 *
 * @author: zhangyu
 */
public class CellsOddValues1252Demo {

    @Test
    public void cellsOddValues() {
        int[][] arr = new int[2][3];
        int row = 1;
        for (int i = 0; i < arr[row].length; i++) {
            arr[row][i] += 1;
        }
        System.out.println();
    }
}
