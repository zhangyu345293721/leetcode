package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No.961 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[5,1,5
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

public class NRepeatedElement961 {

    @Test
    public void nRepeatedElementTest() {
        int[] arr = {1, 2, 3, 3};
        int result = repeatedNTimes(arr);
        System.out.println(result);
        Assert.assertEquals(result, 3);
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
