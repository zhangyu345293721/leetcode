package leetcode.java.array;

import org.junit.Test;

/**
 * 数组进行排序
 *
 * @author: zhangyu
 */
public class SortArrayByParity905 {

    @Test
    public void testSortArrayByParity() {
        int[] arr = {1, 2, 3, 4};
        int[] newArr = sortArrayByParity(arr);
        for (int num : newArr) {
            System.out.print(num + " ");
        }
    }

    /**
     * 对数组进行分类并返回
     *
     * @param A 数组
     * @return 数组
     */
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 == 0) {
                i++;
            } else if (A[j] % 2 == 1) {
                j--;
            } else {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        return A;
    }

    /**
     * 交换两个元素的位置
     *
     * @param a 数组
     * @param i 位置i
     * @param j 位置j
     */
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j]=temp;
    }
}
