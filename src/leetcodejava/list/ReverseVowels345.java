package leetcodejava.list;

import org.junit.Test;

/**
 * 字符串中元音字母反转
 *
 * @author: zhangyu
 */
public class ReverseVowels345 {
    @Test
    public void reverseVolwelsTestDemo() {
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
