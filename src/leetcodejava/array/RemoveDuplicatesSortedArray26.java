package leetcodejava.array;

import org.junit.Test;

/**
 * 在有序数组中去掉重复的数
 *
 * @author: zhangyu
 */
public class RemoveDuplicatesSortedArray26 {
    @Test
    public void testRemoveDuplicatesSortedArray() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = getLength(nums);
        System.out.println(length);
    }

    /**
     * 获取数组的长度
     *
     * @param nums 有序数组
     * @return 长度
     */
    private int getLength(int[] nums) {
        int count = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[count] != nums[j]) {
                nums[++count] = nums[j];
            }
        }
        return count + 1;
    }
}