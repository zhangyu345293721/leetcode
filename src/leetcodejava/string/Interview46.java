package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 46 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Interview46 {

    @Test
    public void interviewTest() {
        int num = 12258;
        int result = translateNum(num);
        System.out.println(result);
        Assert.assertEquals(result, 5);
    }

    /**
     * 翻译数字
     *
     * @param num 数
     * @return 数量
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        if (str.length() < 2) {
            return 1;
        }
        int[] dp = new int[str.length()];
        dp[0] = 1;
        dp[1] = (str.charAt(0) - '0' == 1 || (str.charAt(0) - '0' == 2 && str.charAt(1) - '0' <= 5)) ? 2 : 1;
        for (int i = 2; i < str.length(); i++) {
            char ch1 = str.charAt(i - 1);
            char ch2 = str.charAt(i);
            if (ch1 - '0' == 0 || ch1 - '0' > 2 || (ch1 - '0' == 2 && ch2 - '0' > 5)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[str.length() - 1];
    }
}
