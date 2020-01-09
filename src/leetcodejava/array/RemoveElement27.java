package leetcodejava.array;

import org.junit.Test;

/**
 * 删除元素
 *
 * @author: zhangyu
 */
public class RemoveElement27 {
    @Test
    public void testRemoveElement() {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int leftNumber = removeElement2(arr, val);

        System.out.println(leftNumber);
    }

    /**
     * 删除数组后的数量
     *
     * @param nums 数组
     * @param val  元素
     * @return 最后数量
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int num : nums) {
            if (val == num) {
                count++;
            }
        }
        return nums.length - count;
    }

    /**
     * 删除数组后的数量
     *
     * @param nums 数组
     * @param val  元素
     * @return 最后数量
     */
    public int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (val != num) {
                nums[index++] = num;
            }
        }
        return index;
    }
}

