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
public class ArraysSortTest2 {
    @Test
    public void fun() {
        Integer[] nums = {5, 2, 1, 3, 4, 9, 0, 7, 8, 6};
        // Comparator<Integer> comparator = new MyComparator();
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return -1;
                } else if (a == b) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(Arrays.toString(nums));
    }
}

