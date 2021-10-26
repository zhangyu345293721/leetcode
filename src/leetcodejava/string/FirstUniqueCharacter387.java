package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.680 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FirstUniqueCharacter387 {

    @Test
    public void firstUniqueCharacterTest() {
        String s = "aadadaae";
        int result = getFirstUniqueCharacterIndex(s);
        System.out.println(result);
        Assert.assertEquals(result, 7);
    }

    /**
     * 不重复字符串下标
     *
     * @param s 字符串
     * @return 字符串下标
     */
    private int getFirstUniqueCharacterIndex(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        // 中间出现
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String sub = s.substring(i + 1);
            String subStart = s.substring(0, i);
            if (sub.indexOf(ch) == -1 && subStart.indexOf(ch) == -1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 字符串下标
     *
     * @param s 字符串
     * @return 下标
     */
    private int getFirstUniqueCharacterIndex2(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        for (char ch : s.toCharArray()) {
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return s.indexOf(ch);
            }
        }
        return -1;
    }
}
