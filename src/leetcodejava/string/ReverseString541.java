package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * This is the solution of No.830 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-string-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg" 
 * 提示：
 * <p>
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseString541 {

    @Test
    public void reverseStringTest() {
        String s = "abcdefg";
        int key = 2;
        String result = reverseStr2(s, key);
        System.out.println(result);
        Assert.assertEquals(result, "bacdfeg");
    }

    /**
     * 翻转字符串
     *
     * @param s 字符串s
     * @param k k
     * @return 字符串
     */
    public String reverseStr(String s, int k) {
        LinkedList<String> list = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        int number = s.length() / k;
        for (int i = 0; i < number; i++) {
            list.add(s.substring(i * k, i * k + k));
        }
        if (number * k < s.length()) {
            list.add(s.substring(number * k));
        }
        for (int index = 0; index < list.size(); index++) {
            if (index % 2 == 0) {
                String temp = new StringBuffer(list.get(index)).reverse().toString();
                sb.append(temp);
            } else {
                sb.append(list.get(index));
            }
        }
        return sb.toString();
    }

    /**
     * 翻转字符串
     *
     * @param s 字符串s
     * @param k 数字k
     * @return 字符串
     */
    public String reverseStr2(String s, int k) {
        char[] chs = s.toCharArray();
        for (int start = 0; start < chs.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, chs.length - 1);
            reverseArray(chs, i, j);
        }
        return new String(chs);
    }

    /**
     * 交换两个字符的位置
     *
     * @param chs 字符数组
     * @param i   位置i
     * @param j   位置j
     */
    public void reverseArray(char[] chs, int i, int j) {
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }
}
