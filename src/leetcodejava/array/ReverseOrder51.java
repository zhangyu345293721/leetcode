package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 51 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/remove-element
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseOrder51 {

    @Test
    public void reverseOrderTest() {
        int[] nums = {7, 5, 6, 4};
        int result = reversePairs(nums);
        System.out.println(result);
        Assert.assertEquals(result, 5);
    }

    int[] temp;

    /**
     * 求逆序对
     *
     * @param nums 数组
     * @return 逆序对总数
     */
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序
     *
     * @param nums 数组
     * @param l    坐标l
     * @param r    坐标r
     * @return 数量
     */
    public int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = (l + r) / 2;
        int res = mergeSort(nums, l, m) + mergeSort(nums, m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = temp[j++];
            } else if (j == r + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                res += m - i + 1;  // 统计逆序对
            }
        }
        return res;
    }

    int count = 0;

    /**
     * 求逆序对
     *
     * @param nums 数组
     * @return 逆序对总数
     */
    public int reversePairs2(int[] nums) {
        reversePairs(nums, 0, nums.length - 1);
        return count;
    }

    /**
     * 归并排序递归
     */
    public void reversePairs(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2; // 防止溢出
        if (left >= right) {
            return;
        }
        reversePairs(nums, left, mid);
        reversePairs(nums, mid + 1, right);
        mergeSort(nums, left, mid, right);
    }

    /**
     * 合并两个数组
     */
    public void mergeSort(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int k = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += (mid - i + 1);
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int index = 0; index < temp.length; index++) {
            nums[left + index] = temp[index];
        }
    }
}
