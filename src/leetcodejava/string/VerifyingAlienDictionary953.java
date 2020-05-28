package leetcodejava.string;

/**
 * This is the solution of No.953 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/verifying-an-alien-dictionary
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *

 * 示例 1：
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 *
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verifying-an-alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class VerifyingAlienDictionary953 {

    /**
     * 判断字符串是否按照顺序
     *
     * @param words 字符串
     * @param order 顺序串
     * @return 布尔值
     */
    public boolean isAlienSorted(String[] words, String order) {
        int N = words.length;
        for (int i = 0; i < N - 1; i++) {
            boolean flag = compare(words[i], words[i + 1], order);
            if (!flag) return false;
        }
        return true;
    }

    /**
     * 判断两个字符串是否按照顺序
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @param order 顺序字符串
     * @return 布尔值
     */
    private boolean compare(String word1, String word2, String order) {
        int i = 0;
        int N1 = word1.length();
        int N2 = word2.length();
        while (i < N1 && i < N2 && word1.charAt(i) == word2.charAt(i)) {
            i++;
        }
        if (i == N1 || i == N2) {
            return N1 < N2;
        }
        return order.indexOf(word1.charAt(i)) < order.indexOf(word2.charAt(i));
    }
}
