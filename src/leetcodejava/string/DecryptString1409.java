package leetcodejava.string;

import org.junit.Test;

/**
 * 解析字符串
 *
 * @author: zhangyu
 */
public class DecryptString1409 {
    @Test
    public void testDecryString() {
        String s = "25#";
        String str = freqAlphabets(s);
        System.out.println(str);
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
            if (i+2<s.length()&&s.charAt(i + 2) == '#') {
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
