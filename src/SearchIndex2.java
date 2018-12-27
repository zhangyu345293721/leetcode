// package leetcode;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: SearchIndex2
 * @Description: TOTO
 * @date 2018/11/20 14:03
 **/

public class SearchIndex2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 8, 10};
        int key = 9;
        int index = searchIndex(arr, key);
        System.out.println(index);
    }

    // 二分查找的变种形式，插着一个数在数组中的位置
    private static int searchIndex(int[] nums, int target) {
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
