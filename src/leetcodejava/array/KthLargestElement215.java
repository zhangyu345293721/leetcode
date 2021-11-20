package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This is the solution of No.215 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 通过次数120,951提交次数193,510
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class KthLargestElement215 {
    @Test
    public void kthLargestElementTest() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = kthLargestElement2(nums, k);
        System.out.println(result);
        Assert.assertEquals(result, 5);
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
        for (int i = 0; i < nums.length - k; i++) {
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
    private int kthLargestElement2(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        return quickSort(nums, 0, nums.length - 1, k);
    }

    /**
     * 快速排序选择元素
     *
     * @param nums 数组
     * @param l    位置l
     * @param r    位置r
     * @param k    第k大的数
     * @return 数字
     */
    private int quickSort(int[] nums, int l, int r, int k) {
        while (l <= r) {
            int index = randomPartition(nums, l, r);
            if (index == k - 1) {
                return nums[k - 1];
            } else if (index > k - 1) {
                r = index - 1;
            } else {
                l = index + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * 随机划分
     *
     * @param nums 数组
     * @param l    位置l
     * @param r    位置r
     * @return 选择位置
     */
    private int randomPartition(int[] nums, int l, int r) {
        int randomIndex = (int) Math.random() * (r - l) + l;
        return partition(nums, l, r, randomIndex);
    }

    /**
     * 划分数组，比阈值大的在左边，比阈值小的在右边
     *
     * @param nums 数组
     * @param l    位置l
     * @param r    位置r
     * @return 阈值位置
     */
    private int partition(int[] nums, int l, int r, int index) {
        int pivot = nums[index];
        int rightMost = r;
        swap(nums, index, r);
        while (l <= r) {
            while (l <= r && nums[l] > pivot) {
                l++;
            }
            while (l <= r && nums[r] <= pivot) {
                r--;
            }
            if (l <= r) {
                swap(nums, l, r);
            }
        }
        swap(nums, l, rightMost);
        return l;
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param nums 数组
     * @param l    位置l
     * @param r    位置r
     */
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    /**
     * 找出第k大的值
     *
     * @param nums 数组
     * @param k    k个
     * @return 最大值
     */
    private int kthLargestElement3(int[] nums, int k) {
        PriorityQueue<Integer> priority = new PriorityQueue<>(k + 1);
        for (int num : nums) {
            priority.add(num);
            if (priority.size() > k) {
                priority.poll();
            }
        }
        return priority.poll();
    }
}



