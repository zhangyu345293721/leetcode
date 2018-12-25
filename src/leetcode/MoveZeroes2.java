package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MoveZeroes
 * @Description: TOTO
 * @date 2018/12/2 15:43
 **/

// 把数组中所有的0都移动到数组的最后位置
public class MoveZeroes2 {
    @Test
    public void fun() {
        int[] nums = {0, 0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for(int j=index;j<nums.length;j++){
            nums[j]=0;
        }
    }
}
