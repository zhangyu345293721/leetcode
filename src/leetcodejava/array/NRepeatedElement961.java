package leetcodejava.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出出现n次的数
 *
 * @author: zhangyu
 */
public class NRepeatedElement961 {

    @Test
    public void testNRepeatedElement() {
        int[] arr = {1, 2, 3, 3};
        int num = repeatedNTimes(arr);
        System.out.println(num);
    }

    /**
     * 数组找出出现n次的数
     *
     * @param A 数组A
     * @return 出现的数
     */
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == A.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
