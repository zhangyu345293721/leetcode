package leetcode;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: KthLargestElement
 * @Description: TOTO
 * @date 2018/12/13 17:23
 **/


public class KthLargestElement {
    @Test
    public void fun() {
        Integer[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int key = kthLargestElement3(nums, k);
        System.out.println(key);
    }

   /* // 找出第k小的值
    private int kthLargestElement(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }*/

    // 找出第k小的值
    private int kthLargestElement2(Integer[] nums, int k) {
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return nums[k - 1];
    }

    // 找出第k大的值
    private int kthLargestElement3(Integer[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
            for(int i : nums){
                pq.add(i);
                // 把前面k-1个数都输出
                if(pq.size() > k) pq.poll();
            }
            // 输出第k个数
            return pq.poll();
    }
}



