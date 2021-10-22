package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * This is the solution of No. 739 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/daily-temperatures
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，
 * 请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 
 * temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DailyTemperatures739 {

    @Test
    public void dailyTemperaturesTest() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(result.length, 8);
    }

    /**
     * 生成温度数组
     *
     * @param T 温度数组
     * @return 变化数组
     */
    public int[] dailyTemperatures(int[] T) {
        for (int i = 0; i < T.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    T[i] = j - i;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                T[i] = 0;
            }
        }
        return T;
    }

    /**
     * 生成温度变化数组
     *
     * @param T 温度数组
     * @return 变化数组
     */
    public int[] dailyTemperatures2(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; ++i) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }
        return result;
    }
}
