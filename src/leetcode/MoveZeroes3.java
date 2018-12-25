package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 这种方式是错误的，没有按照题目的要求
 *
 * @author zhangyu
 * @version V1.0
 * @ClassName: MoveZeroes
 * @Description: TOTO
 * @date 2018/12/2 15:43
 **/

// 把数组中所有的0都移动到数组的最后位置
public class MoveZeroes3 {
    @Test
    public void fun() {
        int[] nums = {0, 0, 1};
        moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 移动数组这种效率比较低，不应该去使用，而且循环也不好去控制
    private void moveZeroes3(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] != 0) {
                i++;
            } else if (nums[j] == 0) {
                j--;
            } else {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
