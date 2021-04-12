package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 347 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/top-k-frequent-elements
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TopKFrequentElements347 {

    @Test
    public void topKFrequentElementsTest() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] list = topKFrequent2(nums, k);
        Assert.assertEquals(list.length, 2);
    }

    /**
     * @param nums 数组
     * @param k    前面k数
     * @return 链表
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> frequentMap = getFrequentMap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(k, (e1, e2) -> (e1.getValue() - e2.getValue()));
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            if (maxHeap.size() < k) {
                maxHeap.offer(entry);
            } else if (entry.getValue() > maxHeap.peek().getValue()) {
                maxHeap.poll();
                maxHeap.offer(entry);
            }
        }
        return maxHeap.stream().mapToInt(e -> e.getKey().intValue()).toArray();
    }

    /**
     * 转换成频率map
     *
     * @param nums 数组
     * @return map
     */
    private HashMap<Integer, Integer> getFrequentMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    /**
     * @param nums 数组
     * @param k    前面k数
     * @return 链表
     */
    public int[] topKFrequent2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }
        return frequentMap.entrySet().stream().sorted((e1, e2) -> (e2.getValue() - e1.getValue()))
                .limit(k).mapToInt(e -> e.getKey()).toArray();
    }

    /**
     * @param nums 数组
     * @param k    前面k数
     * @return 链表
     */
    public int[] topKFrequent3(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        // 计算出现次数
        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }
        // 获取数字出现的最大次数
        int maxSize = 0;
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            if (entry.getValue() > maxSize) {
                maxSize = entry.getValue();
            }
        }
        // 找到出现次数最多的数组
        int[] result = new int[k];
        while (k > 0) {
            for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
                if (entry.getValue() == maxSize) {
                    result[k - 1] = entry.getKey();
                    k--;
                }
            }
            maxSize--;
        }
        return result;
    }
}
