package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 分组最小求和
 *
 * @author: zhangyu
 */
public class ArrayPartition561 {

    @Test
    public void testArrayPartion() {
        int nums[] = {1, 2, 3, 4};
        int sum = arrayPairSum(nums);
        System.out.println(sum);
    }

    /**
     * 计算数组中一部分的和
     *
     * @param nums 数组
     * @return 计算和
     */
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            int min = Math.min(nums[i], nums[i + 1]);
            sum += min;
        }
        return sum;
    }
}
