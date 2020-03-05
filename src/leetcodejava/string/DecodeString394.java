package leetcodejava.string;

import org.junit.Test;

/**
 * 解析字符串
 *
 * @author: zhangyu
 */
public class DecodeString394 {
    @Test
    public void testDecodeString() {
        String s = "3[a]2[bc]";
        String result = decodeString(s);
        System.out.println(result);
    }

    /**
     * 解析字符串
     *
     * @param s 输入字符
     * @return 解析后字符串
     */
    public String decodeString(String s) {
        char[] t = s.toCharArray();
        int i = 0, n = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            int idx = s.indexOf('[', i);
            if (idx == -1) {
                sb.append(s.substring(i));
                break;
            }
            while (t[i] < '0' || t[i] > '9') {
                sb.append(t[i]);
                i++;
            }
            int len = Integer.valueOf(s.substring(i, idx));
            int count = 1;
            i = idx + 1;
            while (count != 0) {
                if (t[i] == '[') count++;
                if (t[i] == ']') count--;
                i++;
            }
            String sub = decodeString(s.substring(idx + 1, i - 1));
            for (int k = 0; k < len; k++)
                sb.append(sub);
        }
        return sb.toString();
    }
}
