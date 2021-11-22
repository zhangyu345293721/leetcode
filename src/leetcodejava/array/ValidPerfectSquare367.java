package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.367 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/valid-perfect-square
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 *  
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ValidPerfectSquare367 {

    @Test
    public void validPerfectSquareTest() {
        int num = 16;
        boolean result = isPerfectSquare(num);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 判断是否是完全平方
     *
     * @param num 数num
     * @return 布尔值
     */
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        int i = 1;
        int j = num / 2 + 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            // 防止平方后有值溢出
            long res = 1L * mid * mid;
            if (res < num) {
                i = mid + 1;
            } else if (res > num) {
                j = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
