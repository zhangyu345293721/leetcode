package leetcodejava.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.242 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 *注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *示例 1:
 *
 *输入: s = "anagram", t = "nagaram"
 *输出: true
 *示例 2:
 *
 *输入: s = "rat", t = "car"
 *输出: false
 *提示:
 *1 <= s.length, t.length <= 5 * 104
 *s 和 t 仅包含小写字母
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode.cn/problems/valid-anagram
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class IsAnagram242 {

    @Test
    public void isAnagramTest() {
        String s = "anagram"; 
        String t = "nagaram"
        boolean result = isAnagram(s, t);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 是否是异位字符串
     *
     * @param s 主字符串
     * @param t 比较字符串
     * @return 布尔值
     */
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        int [] arr = new int[26];
        for(char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        for(int ch : t.toCharArray()) {
            arr[ch - 'a']--;
        }
        // 判断是否都是0
        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
