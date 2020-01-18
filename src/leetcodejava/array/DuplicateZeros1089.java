package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 重复0
 *
 * @author: zhangyu
 */
public class DuplicateZeros1089 {

    @Test
    public void testDuplicateZeros() {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
    }


    /**
     * 重复0操作
     *
     * @param arr 数组
     */
    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
           if(num==0){
               list.add(0);
           }
           list.add(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        System.out.println(list);
    }
}
