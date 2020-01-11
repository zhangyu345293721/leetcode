package leetcodejava.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 元素出现次数
 *
 * @author: zhangyu
 */
public class ElementAppearing1287 {
    @Test
    public void testElementAppearing() {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int num = findSpecialInteger(arr);
        System.out.println(num);
    }

    /**
     * 找出特殊的数字
     *
     * @param arr 数组
     * @return 返回数字
     */
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : arr) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (entry.getValue() * 4 > arr.length) {
                return key;
            }
        }
        return -1;
    }
}
