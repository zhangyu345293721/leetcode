package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 16.06 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-binary/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *示例：
 *输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 *输出：3，即数值对(11, 8)
 *提示：
 *
 *1 <= a.length, b.length <= 100000
 *-2147483648 <= a[i], b[i] <= 2147483647
 *正确结果在区间 [0, 2147483647] 内
 *来源：力扣（LeetCode）
 *链接：https://leetcode.cn/problems/smallest-difference-lcci
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddBinary67 {
    @Test
    public void addBinaryTest() {
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};
        int result = smallestDifference(a, b);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 字符串相加(直接位运算)
     *
     * @param a 数组1
     * @param b 数组2
     * @return 最小差值
     */
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int lengthA = a.length;
        int lengthB = b.length;
        int i = 0;
        int j = 0;
        long mins = Integer.MAX_VALUE;
        while (i < lengthA && j < lengthB) {
            if (a[i] < b[j]) {
                mins = Math.min(Math.abs(Long.valueOf(a[i]) - b[j]), mins);
                i++;
            } else {
                mins = Math.min(Math.abs(Long.valueOf(a[i]) - b[j]), mins);
                j++;
            }
        }
        return mins > Integer.MAX_VALUE ? -1 : (int) mins;
    }
}
