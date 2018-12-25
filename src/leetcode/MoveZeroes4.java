package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 利用双指针的方式
 *
 * @author zhangyu
 * @version V1.0
 * @ClassName: MoveZeroes
 * @Description: TOTO
 * @date 2018/12/2 15:43
 **/

// 把数组中所有的0都移动到数组的最后位置
public class MoveZeroes4 {
    @Test
    public void fun() {
        int[] nums = {1, 2, 3, 0, 0, 1};
        moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 移动数组这种效率比较低，不应该去使用，而且循环也不好去控制
    private void moveZeroes3(int[] nums) {
        int i = 0, j = 0;
        // j指向第一个出现的0
        int n = nums.length;
        while (i < n && j < n) {
            // 指向0后面的第一个非0数字
            while (i < n && nums[i] == 0) {
                i++;
            }
            // 如果i,j小于n，交换他们的值，并且他们都+1
            if (i < n && j < n) {
                if (i != j)
                    swap(nums, i, j);

                i++;
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
