package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1409 problem in the book <i>Cracking the Coding Interview</i>,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/queries-on-a-permutation-with-key
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
 * <p>
 * 一开始，排列 P=[1,2,3,...,m]。
 * 对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i] 在 P 中的位置就是 queries[i] 的查询结果。
 * 请你以数组形式返回待查数组  queries 的查询结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = [3,1,2,1], m = 5
 * 输出：[2,1,2,1]
 * 解释：待查数组 queries 处理如下：
 * 对于 i=0: queries[i]=3, P=[1,2,3,4,5], 3 在 P 中的位置是 2，接着我们把 3 移动到 P 的起始位置，得到 P=[3,1,2,4,5] 。
 * 对于 i=1: queries[i]=1, P=[3,1,2,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,3,2,4,5] 。
 * 对于 i=2: queries[i]=2, P=[1,3,2,4,5], 2 在 P 中的位置是 2，接着我们把 2 移动到 P 的起始位置，得到 P=[2,1,3,4,5] 。
 * 对于 i=3: queries[i]=1, P=[2,1,3,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,2,3,4,5] 。
 * 因此，返回的结果数组为 [2,1,2,1] 。
 * 示例 2：
 * <p>
 * 输入：queries = [4,1,2,2], m = 4
 * 输出：[3,1,2,0]
 * 示例 3：
 * <p>
 * 输入：queries = [7,5,5,8,3], m = 8
 * 输出：[6,5,0,7,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m <= 10^3
 * 1 <= queries.length <= m
 * 1 <= queries[i] <= m
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-a-permutation-with-key
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DecryptString1409 {
    @Test
    public void decryStringTest() {
        String s = "25#";
        String result = freqAlphabets(s);
        System.out.println(result);
        Assert.assertEquals(result, "y");
    }

    /**
     * 解析字符串
     *
     * @param s 字符串s
     * @return 解析后字符串
     */
    public String freqAlphabets(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                char resultChar = replaceChar(s.substring(i, i + 3));
                sb.append(resultChar);
                i += 3;
            } else {
                String str = String.valueOf(ch);
                char resultChar = replaceChar(str);
                sb.append(resultChar);
                i++;
            }
        }
        return sb.toString();
    }

    /**
     * 转换字符串为字符
     *
     * @param str 字符串
     * @return 字符
     */
    public char replaceChar(String str) {
        if (str.contains("#")) {
            int num = Integer.valueOf(str.substring(0, str.indexOf('#')));
            return (char) (num - 1 + 'a');
        }
        return (char) (Integer.valueOf(str) - 1 + 'a');
    }
}
