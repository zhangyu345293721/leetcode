package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This is the solution of No. 1207 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/unique-number-of-occurrences
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class UniqueNumberOccurrences1207 {

    @Test
    public void uniqueNumberOccurrencesTest() {
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean result = uniqueOccurrences(arr);
        Assert.assertEquals(result, true);
    }

    /**
     * 独特发生的次数
     *
     * @param arr 数组
     * @return 布尔值
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if (set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }

    /**
     * 独特发生的次数
     *
     * @param arr 数组
     * @return 布尔值
     */
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.values().stream().collect(Collectors.toSet()).size() == map.size();
    }
}
