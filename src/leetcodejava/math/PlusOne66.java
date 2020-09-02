package leetcodejava.math;// package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 66 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/plus-one
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 *  最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

public class PlusOne66 {

    @Test
    public void testPlusOne() {
        int[] digits = {3, 2, 1, 4};
        int[] newArr = getPlusOne(digits);
        System.out.println(Arrays.toString(newArr));
    }


    /**
     * 把数组变成数字
     *
     * @param digits 数字数组
     * @return 数组
     */
    private int[] getPlusOne(int[] digits) {
        Arrays.sort(digits);
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = sum * 10 + digits[i];
        }
        sum = sum + 1;
        int length = getNumberLength(sum);
        int[] newArr = new int[length];
        int index = 0;
        while (sum != 0) {
            newArr[index] = sum % 10;
            sum = sum / 10;
            index++;
        }
        reverseArray(newArr);
        return newArr;
    }


    /**
     * 获取数字的长度
     *
     * @param num 数字
     * @return 数字长度
     */
    private int getNumberLength(int num) {
        int length = 0;
        while (num != 0) {
            num = num / 10;
            length++;
        }
        return length;
    }

    /**
     * 翻转数组
     *
     * @param arr 数组
     */
    private void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
