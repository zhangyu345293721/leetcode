package leetcodejava.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 压缩字符串
 *
 * @author: zhangyu
 */
public class CompressString {

    @Test
    public void testCompressString() {
        String str = "";
        String result = compressString(str);
        System.out.println(result);
    }

    /**
     * 压缩字符串
     *
     * @param S 字符串
     * @return 压缩后字符串
     */
    public String compressString(String S) {
        if (S == null || S.trim().equals("")) {
            return S;
        }
        StringBuffer sb = new StringBuffer();
        List<String> list = splitString(S);
        for (String s : list) {
            sb.append(s.charAt(0));
            sb.append(s.length());
        }
        return sb.toString().length() >= S.length() ? S : sb.toString();
    }

    /**
     * 将相同的字符串切割成字符串链表
     *
     * @param s 字符串
     * @return 字符串链表
     */
    private List<String> splitString(String s) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                list.add(s.substring(start, i + 1));
                start = i + 1;
            }
        }
        list.add(s.substring(start));
        return list;
    }
}
