//package leetcode;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: SearchIndex
 * @Description: TOTO
 * @date 2018/11/20 13:35
 **/


public class SearchIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 10;
        int index = searchIndex(arr, key);
        System.out.println(index);
    }

    private static int searchIndex(int[] nums, int target) {
        if (nums == null){
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
