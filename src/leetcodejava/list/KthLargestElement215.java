package leetcodejava.list;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * This is the solution of No.215 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 通过次数120,951提交次数193,510
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
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



