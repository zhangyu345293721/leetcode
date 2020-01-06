package leetcode.array;

import org.junit.Test;

/**
 * 寻找数字
 *
 * @author: zhangyu
 */
public class FindNumbers1295 {
    @Test
    public void testFindNumber() {
        int[] nums = {12, 345, 2, 6, 7896};
        int count=findNumbers(nums);
        System.out.println(count);
    }

    /**
     * @param nums 数组
     * @return 寻找数字
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
