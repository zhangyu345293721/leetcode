package leetcodejava.array;

/**
 * 插入位置
 *
 * @author: zhangyu
 */
public class SearchInsertPosition35 {

    /**
     * 插入目标数的位置
     *
     * @param nums   目标数组
     * @param target 目标数
     * @return 位置
     */
    private int searchIndex(int[] nums, int target) {
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


    /**
     * 插入目标数的位置
     *
     * @param nums   目标数组
     * @param target 目标数
     * @return 位置
     */
    public int searchIndex2(int[] nums, int target) {
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
}