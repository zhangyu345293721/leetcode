package leetcodejava.array;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author: zhangyu
 */
public class SortArray912 {
    @Test
    public void testSortArray() {
        int[] nums = {4, 1, 3, 4, 5, 7};
        int[] arr = sortArray(nums);
        System.out.println(arr);
    }

    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int num : nums) {
            queue.add(num);
        }
        int[] array = new int[nums.length];
        int index = 0;
        while (queue.iterator().hasNext()) {
            array[index++] = queue.poll();
        }
        return array;
    }
}
