package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 0803 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/magic-index-lcci
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MagicIndexLCCI {

    @Test
    public void magicIndexLCCITest() {
        int[] nums = {0, 2, 3, 4, 5};
        int magicIndex = findMagicIndex(nums);
        System.out.println(magicIndex);

    }

    /**
     * 寻找魔术索引下标
     *
     * @param nums 数组
     * @return 下标index
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 寻找魔术索引下标
     *
     * @param nums 数组
     * @return 下标index
     */
    public int findMagicIndex2(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    /**
     * 获取答案
     *
     * @param nums  数组nums
     * @param left  左下标
     * @param right 右下标
     * @return 获取下标
     */
    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
}
