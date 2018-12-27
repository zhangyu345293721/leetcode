//package leetcode;

import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MergeArray2
 * @Description: TOTO
 * @date 2018/11/21 20:41
 **/

public class MergeArray2 {
    @Test
    public void fun() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {-1,2,3, 4, 5, 6, 7};
        int[] newArr = merge(arr1, arr2);
        for (int number : newArr) {
            System.out.print(number + " ");
        }
    }
    // 计算机数组合并之后的新数组
    private int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }
        Set<Integer> set = new TreeSet();
        for (int arrNnum1 : arr1) {
            set.add(arrNnum1);
        }
        for (int arrNum2 : arr2) {
            set.add(arrNum2);
        }
        int[] newArr = new int[set.size()];
        int count = 0;
        for (int number : set) {
            newArr[count] = number;
            count++;
        }
        return newArr;
    }
}
