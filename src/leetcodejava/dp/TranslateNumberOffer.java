package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.Offer46 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TranslateNumberOffer {

    @Test
    public void translateNumberOfferTest() {
        int num = 12258;
        int result = translateNum(num);
        System.out.println(result);
        Assert.assertEquals(result, 5);
    }

    /**
     * 翻译数字
     *
     * @param num 数字
     * @return 结果
     */
    public int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        // 把⼗进制数转化成数字数组
        List<Integer> digitList = new ArrayList<>();
        while (num != 0) {
            digitList.add(num % 10);
            num /= 10;
        }
        int n = digitList.size();
        int[] digits = new int[n];
        for (int i = 0; i < n; ++i) {
            digits[i] = digitList.get(n - i - 1);
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // dp[i]表示digits[0~i-1](⻓度为i)转化为字⺟有多少种⽅法
        // dp[i] = dp[i-1] + dp[i-2](digits[i-2, i-1]可翻译)
        // dp[i] = dp[i-1] (digits[i-2, i-1]不可翻译)
        for (int i = 1; i <= n; ++i) { // 爬楼梯
            if (i - 2 >= 0 && isValid(digits[i - 2], digits[i - 1])) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else { // (digits[i-2, i-1]不可翻译)
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    /**
     * 判断是否合法
     *
     * @param a 数字a
     * @param b 数字b
     * @return 布尔值
     */
    private boolean isValid(int a, int b) {
        if (a == 1) {
            return true;
        }
        if (a == 2 && b >= 0 && b <= 5) {
            return true;
        }
        return false;
    }
}
