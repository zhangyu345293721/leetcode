package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 153 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindMinimumRotatedSortedArray153 {

    @Test
    public void findMinimumRotatedSortedArrayTest() {
        int[] nums = {3, 4, 5, 1, 2};
        int result = findMin(nums);
        System.out.println(result);
        Assert.assertEquals(result, 1);
    }

    /**
     * 查询最小值
     *
     * @param nums 数组
     * @return 下标
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // 特殊处理low == high的情况
            if (low == high) {
                return nums[mid];
            }
            // 先处理命中情况
            if ((mid != 0 && nums[mid] < nums[mid - 1])
                    || (mid == 0 && nums[mid] < nums[high])) {
                return nums[mid];
            } else if (nums[mid] > nums[high]) { // 右循环有序
                low = mid + 1;
            } else { // 右侧⾮循环有序
                high = mid - 1;
            }
        }
        return -1;//永远到不了这⾥
    }
}
