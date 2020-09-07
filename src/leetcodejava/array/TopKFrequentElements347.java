package leetcodejava.array;

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
        int[] list = topKFrequent3(nums, k);
        System.out.println(list);

    }

    /**
     * @param nums 数组
     * @param k    前面k数
     * @return 链表
     */
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> frequentMap = getFrequentMap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> minheap = new PriorityQueue<>(k, (e1, e2) -> (e1.getValue() - e2.getValue()));
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            if (minheap.size() < k) {
                minheap.offer(entry);
            } else {
                if (entry.getValue() > minheap.peek().getValue()) {
                    minheap.poll();
                    minheap.offer(entry);
                }
            }
        }
        while (!minheap.isEmpty()) {
            result.add(minheap.poll().getKey());
        }
        return result.stream().mapToInt(e -> e.intValue()).toArray();
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
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> frequentMap = getFrequentMap(nums);
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : frequentMap.keySet()) {
            int freq = frequentMap.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
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
        HashMap<Integer, Integer> frequentMap = getFrequentMap(nums);
        return frequentMap.entrySet().stream().sorted((e1, e2) -> (e2.getValue() - e1.getValue())).limit(k).mapToInt(e -> e.getKey()).toArray();
    }
}
