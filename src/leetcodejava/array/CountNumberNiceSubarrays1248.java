package leetcodejava.array;

import org.junit.Test;

/**
 * @author: zhangyu
 */
public class CountNumberNiceSubarrays1248 {

    @Test
    public void countNumberNiceSubarraysTest() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 1;
        int count = numberOfSubarrays(nums, k);
        System.out.println(count);
    }

    /**
     * 完美数组数量
     *
     * @param nums 数组
     * @param k    k个基数
     * @return 数量
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int[] subArray = arraySub(nums, i, j);
                count += statisticCount(subArray, k);
            }
        }
        return count;
    }

    /**
     * 最美数组
     *
     * @param subArray 子数组
     * @param count    数量
     * @return 最美数组
     */
    private int statisticCount(int[] subArray, int count) {
        int number = 0;
        for (int num : subArray) {
            if (num % 2 == 1) {
                number++;
            }
        }
        return count == number ? 1 : 0;
    }

    /**
     * 截取数组
     *
     * @param data  数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 数组
     */
    public int[] arraySub(int[] data, int start, int end) {
        int[] arr = new int[end - start + 1];
        int j = 0;
        for (int i = start; i <= end; i++) {
            arr[j] = data[i];
            j++;
        }
        return arr;
    }
}
