package leetcode.math;

/**
 * 寻找下标
 *
 * @author zhangyu
 **/

public class SearchIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 8, 10};
        int key = 9;
        int index = searchIndex1(arr, key);
        System.out.println(index);
    }


    /**
     * 二分查找的变种形式，插着一个数在数组中的位置
     *
     * @param nums   数组
     * @param target 目标
     * @return 返回下标
     */
    private static int searchIndex1(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int middle = i + (j - i) / 2;
            if (nums[middle] > target) {
                j = middle - 1;
            } else if (nums[middle] < target) {
                if (nums[middle + 1] >= target) {
                    return middle + 1;
                } else {
                    i = middle + 1;
                }
            } else {
                return middle;
            }
        }
        if (nums[j] < target) {
            return j + 1;
        }
        return -1;
    }

    /**
     * 寻找下标
     *
     * @param nums   数组
     * @param target 目标
     * @return 返回下标
     */
    private static int searchIndex2(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        if (nums[0] >= target) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
        }
        return -1;
    }
}
