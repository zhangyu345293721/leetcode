package leetcodejava.string;

import org.junit.Test;

/**
 * This is the solution of No.830 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-only-letters
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseOnlyLetters917 {

    @Test
    public void reverseOnlyLettersTest() {
        String str = "ab-cd";
        String result = reverseOnlyLetters1(str);
        System.out.println(result);

    }

    /**
     * 仅仅反转字符
     *
     * @param S 字符串
     * @return 字符串
     */
    private String reverseOnlyLetters1(String S) {
        if (S.length() <= 1) {
            return S;
        }
        char[] chs = S.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i < j) {
            if (Character.isLetter(chs[i]) && Character.isLetter(chs[j])) {
                swap(chs, i++, j--);
            } else if (Character.isLetter(chs[i])) {
                j--;
            } else if (Character.isLetter(chs[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(chs);
    }

    /**
     * 交换字符
     *
     * @param chs 字符串数组
     * @param i   位置i
     * @param j   位置j
     */
    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
