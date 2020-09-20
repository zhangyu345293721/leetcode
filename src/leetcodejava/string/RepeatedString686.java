package leetcodejava.string;


import org.junit.Test;

/**
 * This is the solution of No.686 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/repeated-string-match
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 *
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 *
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 *
 * 注意:
 *
 *  A 与 B 字符串的长度在1和10000区间范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RepeatedString686 {
    @Test
    public void repeatedStringTest() {
        String A = "abcd";
        String B = "cdabcdab";
        int count = repeatedStringMatch(A, B);
        System.out.println("count = " + count);
    }

    /**
     * 找出A重复的最小次数包含B
     *
     * @param A 输入字符串A
     * @param B 字符串C
     * @return
     */
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int repeatTimes = B.length() / A.length() + 1;
        while (i < repeatTimes) {
            sb.append(A);
            i++;
            if (sb.toString().contains(B)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 重复字符串
     *
     * @param A 字符串A
     * @param B 字符串B
     * @return 重复字符串
     */
    public int repeatedStringMatch2(String A, String B) {
        StringBuilder res = new StringBuilder(A);
        int max = A.length() + B.length() + A.length();
        int count = 1;
        while (res.length() < max && res.indexOf(B) == -1) {
            res.append(A);
            count++;
        }
        return res.indexOf(B) == -1 ? -1 : count;
    }
}
