// package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: TopKTest2
 * @Description: TOTO
 * @date 2018/11/20 21:03
 **/


public class TopKTest2 {
    @Test
    public void fun() {
        int arr[] = {1, 2, 3, 4, 2, 3, 5, 4, 1, 2, 3, 4, 6, 7};
        int k = 3;
        List<Integer> newList = getTopK(arr, k);
        System.out.println(newList);
    }

    // 返回出现频率最高的前k个数
    private List getTopK(int[] nums, int k) {
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

    // 将value存储到链表，并倒序排列
    public List getReverseSortList(Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : map.keySet()) {
            list.add(map.get(i));
        }
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }

    // 出现次数用表存储起来
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
}
