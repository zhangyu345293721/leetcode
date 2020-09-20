package leetcodejava.string;


import org.junit.Test;

/**
 * This is the solution of No.434 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class NumberSegments434 {
    @Test
    public void numberSegmentsTest() {
        String str = "    foo    bar";
        int count = countSegments(str);
        System.out.println(count);
    }

    /**
     * 对字符串进行划分
     *
     * @param s 输入字符串
     * @return  划分个数
     */
    public int countSegments(String s) {
        if (s == null || s.trim().length() < 1) {
            return 0;
        }
        String[] strs = s.trim().split("[ ]+");
        return strs.length;
    }
}
