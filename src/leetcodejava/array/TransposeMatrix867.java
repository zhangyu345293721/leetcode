package leetcodejava.array;

import org.junit.Test;

/**
 * 转置二维数组
 *
 * @author: zhangyu
 */
public class TransposeMatrix867 {

    @Test
    public void testTransposeMatrix() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] A = transpose(a);
        System.out.println();
    }

    /**
     * 转置一个二维数组
     *
     * @param A 二维数组
     * @return 转置后数组
     */
    public int[][] transpose(int[][] A) {
        int r = A[0].length;
        int c = A.length;
        int[][] result = new int[r][c];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
