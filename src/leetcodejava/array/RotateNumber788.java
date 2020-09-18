package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 788 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/rotated-digits
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * 示例：
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * <p>
 * 提示：
 * N 的取值范围是 [1, 10000]。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RotateNumber788 {
    @Test
    public void testRotateNumber() {
        int n = 10;
        int number = rotatedDigits(n);
        System.out.println(number);
    }

    /**
     * 旋转数字
     *
     * @param N 数字
     * @return 数量
     */
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 0; i <= N; i++) {
            String strN = String.valueOf(i);
            if ((strN.contains("2") || strN.contains("5") || strN.contains("6") || strN.contains("9")) && (!strN.contains("3") && !strN.contains("4") && !strN.contains("7"))) {
                count++;
            }
        }
        return count;
    }
}
