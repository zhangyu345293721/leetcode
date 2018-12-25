package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 循环这个方式没有很好的去控制，不能使用(没有想到更好的方法)
 *
 * @author zhangyu
 * @version V1.0
 * @ClassName: MoveZeroes
 * @Description: TOTO
 * @date 2018/12/2 15:43
 **/

// 把数组中所有的0都移动到数组的最后位置
public class MoveZeroes {
    @Test
    public void fun() {
        int[] nums = {0, 0, 1};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 移动数组这种效率比较低，不应该去使用，而且循环也不好去控制
    private void moveZeroes2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }else{
                i++;
            }
        }
    }
}
