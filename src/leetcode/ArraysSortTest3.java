package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ArraysSortTest
 * @Description: 测试Arrays.sort的逆序排序
 * @date 2018/12/10 14:06
 **/

// Arrays.sort()可以使用内部的比较器进行比较，也可以自己定义比较器进行逆序排序
public class ArraysSortTest3 {
    @Test
    public void fun() {
        Integer[] nums = {5, 2, 1, 3, 4, 9, 0, 7, 8, 6};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        System.out.println(Arrays.toString(nums));
    }
}

