package leetcodejava.array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 单个数字
 *
 * @author: zhangyu
 */
public class SingleNumber136 {

    @Test
    public void testSingleNumber() {
        int[] arr = {2, 3, 3, 2, 4};
        int num = singleNumer1(arr);
        System.out.println(num);
    }

    /**
     * 获取单个数
     *
     * @param nums 数组
     * @return 单个数
     */
    private int singleNumer1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums) {
            if (set.contains(ele)) {
                set.remove(ele);
            } else {
                set.add(ele);
            }
        }
        return (int) set.toArray()[0];
    }

    /**
     * 获取单个数
     *
     * @param nums 数组
     * @return 单个数
     */
    private int singleNumer2(int[] nums) {
        int singleNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }
}
