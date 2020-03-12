package leetcodejava.string;

import org.junit.Test;

/**
 * 按照要求反转字符串
 *
 * @author: zhangyu
 */
public class ReverseOnlyLetters917 {

    @Test
    public void testReverseOnlyLetters() {
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
