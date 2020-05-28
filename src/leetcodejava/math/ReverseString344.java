package leetcodejava.math;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the solution of No.344 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseString344 {

    @Test
    public void testReverseString() {
        String s = "abcdefg";
        String s1 = getReverseString(s, 2);
        System.out.println(s1);
    }

    /**
     * 一个字符串按照要求返回
     *
     * @param str 字符串
     * @param n   位置
     * @return 返回字符串
     */
    public String getReverseString(String str, int n) {
        List<String> list = getStringList(str, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if ((i & 1) == 0) {
                sb.append(new StringBuffer(list.get(i)).reverse().toString());
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    /**
     * 获取字符串链表
     *
     * @param str 字符串
     * @param n   位置
     * @return 链表
     */
    private List<String> getStringList(String str, int n) {
        ArrayList<String> list = new ArrayList<String>();
        String regEx = "\\w{" + n + "}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        if (n * (list.size()) < str.length()) {
            list.add(str.substring(n * list.size()));
        }
        return list;
    }
}
