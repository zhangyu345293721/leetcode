package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.438 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindAllAnagrams438 {
    @Test
    public void findAllAnagramsTest() {
        String s = "baa";
        String p = "aa";
        List<Integer> list = findAllAnagrams1(s, p);
        System.out.println(list);
        Assert.assertEquals((int) list.get(0), 1);
    }

    /**
     * @param s 字符串s
     * @param p 字符串p
     * @return 链表
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sl = s.length(), pl = p.length();
        if (sl < pl) {
            return result;
        }
        int[] pa = new int[26];
        for (char c : p.toCharArray()) {
            pa[c - 'a']++;
        }
        int[] sa = new int[26];
        char[] sc = s.toCharArray();
        for (int i = 0; i < pl; i++) {
            sa[sc[i] - 'a']++;
        }
        if (isSame(sa, pa)) {
            result.add(0);
        }
        for (int i = pl; i < sl; i++) {
            sa[sc[i] - 'a']++;
            sa[sc[i - pl] - 'a']--;
            if (isSame(sa, pa)) {
                result.add(i - pl + 1);
            }
        }
        return result;
    }

    /**
     * 判断两个数组是否相同
     *
     * @param sa 数组1
     * @param pa 数组2
     * @return 布尔值
     */
    private boolean isSame(int[] sa, int[] pa) {
        for (int i = 0; i < 26; i++) {
            if (sa[i] != pa[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不按照顺序获取所有下标
     *
     * @param s 字符串s
     * @param p 字符串p
     * @return 链表
     */
    private List<Integer> findAllAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int l = p.length();
        int[] chs = new int[26];
        int[] chp = new int[26];
        for (char ch : p.toCharArray()) {
            chp[ch - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (i >= l) {
                chs[s.charAt(i - l) - 'a']--;
            }
            chs[s.charAt(i) - 'a']++;
            if (isSame(chs, chp)) {
                result.add(i - l + 1);
            }
        }
        return result;
    }
}
