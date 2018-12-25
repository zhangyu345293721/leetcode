package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: FindAllAnagrams
 * @Description: TOTO
 * @date 2018/12/5 17:22
 **/


public class FindAllAnagrams2 {
    @Test
    public void fun() {
        String s = "baa";
        String p = "aa";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sl = s.length(), pl = p.length();
        if (sl < pl) {
            return ans;
        }
        int[] pa = new int[26];
        // 让这些字符都映射在这26个数字中
        for (char c : p.toCharArray()) {
            System.out.println(pa[c - 'a']++);
        }

        int[] sa = new int[26];
        char[] sc = s.toCharArray();
        for (int i = 0; i < pl; i++) {
            sa[sc[i] - 'a']++;
        }
        if (isSame(sa, pa)) {
            ans.add(0);
        }
        for (int i = pl; i < sl; i++) {
            sa[sc[i] - 'a']++;
            sa[sc[i - pl] - 'a']--;
            if (isSame(sa, pa)) ans.add(i - pl + 1);
        }
        return ans;
    }

    private boolean isSame(int[] sa, int[] pa) {
        for (int i = 0; i < 26; i++) {
            if (sa[i] != pa[i]) return false;
        }
        return true;
    }
}
