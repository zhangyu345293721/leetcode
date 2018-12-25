package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: BinarySortTest
 * @Description: TOTO
 * @date 2018/12/13 10:17
 **/


public class BinarySortTest {
    @Test
    public void fun() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int index1 = Arrays.binarySearch(arr, 0, 4, 4);
        int index2 = Arrays.binarySearch(arr, 0, 4, 0);
        int index3 = Arrays.binarySearch(arr, 0, 4, 6);
        int index4 = Arrays.binarySearch(arr, 9);
        int index5 = Arrays.binarySearch(arr, 0);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
        System.out.println(index5);
    }
}
