package leetcodejava.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 1287 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 * 示例：
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 * 提示：
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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
