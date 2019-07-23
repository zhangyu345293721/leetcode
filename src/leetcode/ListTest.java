package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ListTest
 * @Description: 利用jdk8测试defaut类型
 * @date 2018/11/28 10:01
 **/

public class ListTest {
    @Test
    public void HashMapTest() {
        int[] arr = {1, 2, 3, 1, 1, 2, 4, 6};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            /*if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }*/
        }
        for (int key : map.keySet()) {
            System.out.println(key + "--" + map.get(key));
        }
    }
}
