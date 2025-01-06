package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * ==========================================================================================================
 * get min squares
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddTwoNumbers2 {
    @Test
    public void addTwoNumbers() {
        List<Integer> result = numSquares(12);
        System.out.println(result);
        Assert.assertEquals(result.size(), 3);
    }

    public static List<Integer> numSquares(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // define dp array
        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];
        // init dp array
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        // state transition
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i * i <= j; i++) {
                if (dp[j] > dp[j - i * i] + 1) {
                    dp[j] = dp[j - i * i] + 1;
                    dp2[j] = i * i;
                }
            }
        }
        // System.out.println(1000);
        List<Integer> result = new ArrayList();
        while (n > 0) {
            result.add(dp2[n]);
            n = n - dp2[n];
        }
        System.out.println(result);
        return result;
    }
}
