package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ArrayTest
 * @Description: TOTO
 * @date 2018/12/17 21:28
 **/


public class ArrayTest {
    @Test
    public void fun() {
        int sum1 = getSum(1, 2, 3, 4);
        int sum2 = getSum(1, 2, 3);
        System.out.println(sum1);
        System.out.println(sum2);
    }

    private int getSum(int... arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
