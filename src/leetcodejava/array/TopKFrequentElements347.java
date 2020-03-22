package leetcodejava.array;

import java.util.*;

/**
 * 出现频次最高的k个数
 *
 * @author: zhangyu
 */
public class TopKFrequentElements347 {

    /**
     * @param nums 数组
     * @param k    前面k数
     * @return 链表
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = computeAppearTimes(nums);
        List<Integer> list = getReverseSortList(map);
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            for (int key : map.keySet()) {
                if (map.get(key) == list.get(i)) {
                    newList.add(key);
                    map.put(key, 0);
                }
            }
        }
        return newList;

    }

    /**
     * 将value存储到链表，并倒序排列
     *
     * @param map map
     * @return 链表
     */
    public List getReverseSortList(Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : map.keySet()) {
            list.add(map.get(i));
        }
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }

    /**
     * 出现次数用表存储起来
     *
     * @param arr 数组
     * @return map
     */
    private Map<Integer, Integer> computeAppearTimes(int[] arr) {
        Map<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < arr.length; i++) {
            if (!map.keySet().contains(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        return map;
    }

    /**
     * @param nums 数组
     * @param k    前面k数
     * @return 链表
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = getfreqmap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> minheap = new PriorityQueue<Map.Entry<Integer, Integer>>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
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
            result.add(0, minheap.poll().getKey());
        }
        return result;
    }

    private HashMap<Integer, Integer> getfreqmap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return map;
    }

    /**
     * @param nums 数组
     * @param k    前面k数
     * @return 链表
     */
    public List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && res.size() < k; i--) {
            if(bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
    }

}