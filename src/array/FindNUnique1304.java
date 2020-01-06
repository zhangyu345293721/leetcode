package array;

import org.junit.Test;

/**
 * 找出数组总和为0
 *
 * @author: zhangyu
 */
public class FindNUnique1304 {


    @Test
    public void testFindNunique() {
        int arr[] = sumZero(5);
        for (int num : arr) {
            System.out.print(num);
        }
    }

    /**
     * 返回总和为0的数组
     *
     * @param n n个数字
     * @return 总和为0的数组
     */
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int j = n - 1;
        for (int i = 0; i < (n / 2); i++) {
            arr[i] = i + 1;
            arr[j] = -arr[i];
            j--;
        }
        return arr;
    }
}
