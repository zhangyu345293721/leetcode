package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 283 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/move-zeroes
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

public class MoveZeroes283 {
    @Test
    public void moveZeroesTest() {
        int[] nums = {0, 0, 1};
        moveZeroes(nums);
        Assert.assertArrayEquals(nums, new int[]{1, 0, 0});
    }

    /**
     * 移动数组将非0的地方不变，后面的地方覆盖0
     *
     * @param nums 数组
     */
    private void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 移动数组将非0的地方不变，后面的地方覆盖0
     *
     * @param nums 数组
     */
    private void moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index++, i);
            }
        }
    }

    /**
     * 交换两个元素的位置
     *
     * @param nums 数组
     * @param i    位置i
     * @param j    位置j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
