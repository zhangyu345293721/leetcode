package leetcode.java.tree;

import org.junit.Test;

public class FindFirstLastPosition34 {
    @Test
    public void testFindFirstLastPosition() {
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println("nums");
        int index = findLastPosition(nums, target);
        System.out.println(index);

    }

    /**
     * 找出相同的里面最小那个
     *
     * @param nums   数组
     * @param target 目标值
     * @return
     */
    private int findFirstPosition(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            }
        }
        return index;
    }

    /**
     * 找出相同中最后面那个
     *
     * @param nums   数组
     * @param target 目标值
     * @return int
     */
    private int findLastPosition(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            }
        }
        return index;
    }
}
