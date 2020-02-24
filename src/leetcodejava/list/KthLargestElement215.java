package leetcodejava.list;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 **/


public class KthLargestElement215 {
    @Test
    public void testKthLargestElement() {
        Integer[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int key = kthLargestElement2(nums, k);
        System.out.println(key);
    }


    /**
     * 找出第k大的值
     *
     * @param nums 数组
     * @param k    个数
     * @return 数字
     */
    private int kthLargestElement(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    /**
     * 找出第k大的值
     *
     * @param nums 数组
     * @param k    个数
     * @return 数字
     */
    private int kthLargestElement2(Integer[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return list.get(k - 1);
    }

    /**
     * 找出第k大的值
     *
     * @param nums 数组
     * @param k    k个
     * @return 最大值
     */
    private int kthLargestElement3(Integer[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}



