package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用了基本的方法没有做出来，现在就要用深度优先算法来进行计算；
 * @author zhangyu
 * @version V1.0
 * @ClassName: TargetSum
 * @Description: TOTO
 * @date 2018/11/29 20:59
 **/


public class TargetSum {
    @Test
    public void fun() {
        int[] nums = {1, 8, 9, 3, 4, 5, 7};
        int target = 20;
        LinkedList queue=new LinkedList();
        int way = findTargetSumWays(nums, target);
        System.out.println(way);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int max = compute(nums, "+");
        int min = compute(nums, "-");
        if (S > max || S < min) {
            return 0;
        }
        return -1;
    }

    /* private int computeMin(int[] nums) {
         int maxSum=0;
         for(int i:nums){
             maxSum=maxSum+i;
         }
         return maxSum;
     }
     private int computeMax(int[] nums) {
         int minSum=0;
         for(int i:nums){
             minSum=minSum-i;
         }
         return minSum;
     }*/
    private int compute(int[] nums, String operator) {
        int sum = 0;
        if ("+".equals(operator)) {
            for (int i : nums) {
                sum = sum + i;
            }
        }
        if ("-".equals(operator)) {
            for (int i : nums) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
