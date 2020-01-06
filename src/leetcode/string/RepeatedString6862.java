package leetcode.string;


import org.junit.Test;

/**
 * 重复字符串(换一种思路)
 *
 * @author: zhangyu
 */
public class RepeatedString6862 {
    @Test
    public void repeatedStringTestDemo() {
        String A = "abcd";
        String B = "cdabcdab";
        int count = repeatedStringMatch(A, B);
        System.out.println("count = " + count);
    }

    /**
     * 重复字符串
     *
     * @param A 字符串A
     * @param B 字符串B
     * @return 重复字符串
     */
    public int repeatedStringMatch(String A, String B) {
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
