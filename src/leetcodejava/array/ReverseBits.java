package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 0503 problem in the LeetCode,
 * the website of the problem is as follow:
 * ttps://leetcode-cn.com/problems/reverse-bits-lcci
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseBits {

    @Test
    public void reverseBitsTest() {
        int n = 1775;
        int result = reverseBits(n);
        System.out.println(result);
        Assert.assertEquals(result, 8);
    }

    /**
     * 比特位0变为1，最大长度
     *
     * @param num 数
     * @return 最大值
     */
    public int reverseBits(int num) {
        if (num == 0) {
            return 1;
        }
        int nums[] = new int[32];
        int index = 31;
        while (num > 0) {
            nums[index--] = num & 1;
            num >>= 1;
        }
        int[] leftMax = new int[32];
        int count = 0;
        for (int i = 0; i < 32; i++) {
            leftMax[i] = count;
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
        }
        count = 0;
        int[] rightMax = new int[32];
        for (int i = 31; i >= 0; i--) {
            rightMax[i] = count;
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = Math.max(result, leftMax[i] + rightMax[i] + 1);
        }
        return result;
    }
}
