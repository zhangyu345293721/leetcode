package leetcodejava.array;

import org.junit.Test;

/**
 * 操作数后偶数和
 *
 * @author: zhangyu
 */
public class SumEvenNumbers985 {
    @Test
    public void testSumEvenNumbers() {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] newA = sumEvenAfterQueries(A, queries);
        System.out.println(newA);
    }

    /**
     * @param A       数组
     * @param queries 二维数组
     * @return 数组
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] newA = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int num = queries[i][0];
            A[index] = A[index] + num;
            int count = getCount(A);
            newA[i] = count;
        }
        return newA;
    }


    /**
     * 获取数组的和
     *
     * @param A 数组
     * @return 和
     */
    private int getCount(int[] A) {
        int count = 0;
        for (int number : A) {
            if (number % 2 == 0) {
                count += number;
            }
        }
        return count;
    }
}
