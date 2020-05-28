package leetcodejava.list;

import org.junit.Test;

/**
 * This is the solution of No. 345 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseVowels345 {
    @Test
    public void testReverseVolwels() {
        String str = reverseVowels("Aa");
        System.out.println("str = " + str);
    }

    /**
     * @param s 传入包含元音字符的字符串
     * @return 返回倒转之后的字符串
     */
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i < j) {
            if (!isVolwel(chs[i])) {
                i++;
            } else if (!isVolwel(chs[j])) {
                j--;
            } else {
                swap(chs, i, j);
                i++;
                j--;
            }
        }
        return new String(chs);

    }

    /**
     * 交换元素的位置
     *
     * @param chs 输入层字符数组
     * @param i   位置i
     * @param j   位置j
     */
    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    /**
     * 判断该字符是不是元音字母
     *
     * @param ch 字符
     * @return 布尔类型
     */
    public boolean isVolwel(char ch) {
        String volwels = "aeiou";
        return volwels.contains(String.valueOf(ch).toLowerCase());
    }
}
