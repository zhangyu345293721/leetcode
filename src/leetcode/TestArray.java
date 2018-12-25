package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: TestArray
 * @Description: TOTO
 * @date 2018/12/4 18:03
 **/


public class TestArray {
    @Test
    public void fun(){
        int [] arr={1,3,2};
        int [] newArr=Arrays.copyOf(arr,arr.length);
        Arrays.sort(newArr);
        System.out.println(Arrays.toString(newArr));
        System.out.println(Arrays.toString(arr));
    }
}
