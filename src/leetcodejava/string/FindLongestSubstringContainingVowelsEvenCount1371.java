package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No.680 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 示例 2：
 * <p>
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 示例 3：
 * <p>
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 *  
 * 提示：
 * <p>
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindLongestSubstringContainingVowelsEvenCount1371 {

    @Test
    public void findLongestSubstringContainingVowelsEvenCountTest() {
        String s = "bpgmxrkhdcvxbnogftqgqmqlghlvsyyckbobtfejpbsqcsmcmzqsujmilpbrpanjsxkzetsrictzzylnmqzassdbsqadkklyrbulscpucrokqzrafklgesesdmkqnlkitlbwcyuhziymrjsztccwfincejrxuihgdixpbxqjzzgrcrkkjqebolzxbaknxfrbwswvuqnfghdsesqdxiogzbloktxlhuaapbfirbahycqfbqggojhpqlkmucgtfgvtjsntplapadvusvtnwskkcungwqzptsvrqptvxsyotpfivqjsyzmtriijatybzoolhqogwpkwuemnbudlzaiyrxbjmakkjszbgwckdvuceywjntkhauwwfyyyqxsuljjmnqozcgnhtbthuhhwmmgtexjxxlawwvjopfvealnrkzqpktdsujzrvinajycupdqhtxuxinlzhbdtqqqfejbcgavbnxwacbabrkkzatargpgijsrqihfgmbhrwobkkndasfqucyfghfjzdbzkxecoehbxjlbscogzhvfdbgbxxdczzxhjwiqnhxbxiygklloyvtmvmcnhpkftudhcyznirjkylnollkmpqalejfjserwxefouueefctihlukfipjcnerlodevkcvfprbbxgulxlqlzquzvlkudfmbitwzgbhjksmhlybhjwsagdehlqiefhcjsqqrtrznosqpfqlgnzcighyeeygafplfbzlcthvwgcouugtkfswvwagkprbblprlepcqkvxsvjtkzscpkncicvukafkhkiijpnajfujbdnntgilyuxspsjtivfkeldmlqxswgmoepwhbxuhcxcbqqpspwkqzfswpmam";
        int result = findTheLongestSubstring2(s);
        System.out.println(result);
        Assert.assertEquals(result, 806);
    }

    /**
     * 寻找最长字符串
     *
     * @param s 字符串
     * @return 最长值
     */
    public int findTheLongestSubstring(String s) {
        boolean flag = false;
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                flag = judgeLongestSubstring(subStr);
                if (flag) {
                    if (maxlength < subStr.length()) {
                        maxlength = subStr.length();
                    }
                }
            }
        }
        return maxlength;
    }

    /**
     * 判断字符串元音字符是偶数
     *
     * @param subStr 子字符串
     * @return 布尔值
     */
    private boolean judgeLongestSubstring(String subStr) {
        char[] arr = {'a', 'e', 'i', 'o', 'u'};
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            map.put(ch, 0);
        }
        char[] chs = subStr.toCharArray();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (int num : map.values()) {
            if (num % 2 == 1) {
                return false;
            }
        }
        return true;
    }


    private static final String VOWELS = "aeiou";


    /**
     * 寻找最长字符串
     *
     * @param s 字符串
     * @return 最长值
     */
    public int findTheLongestSubstring2(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = s.length();
        int state = 0; // (00000)
        int maxSize = 0;
        map.putIfAbsent(0, -1);
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < VOWELS.length(); k++) {
                if (s.charAt(i) == VOWELS.charAt(k)) {
                    state ^= (1 << (VOWELS.length() - k - 1));
                    break;
                }
            }
            if (map.containsKey(state)) {
                maxSize = Math.max(maxSize, i - map.get(state));
            }
            map.putIfAbsent(state, i);
        }
        return maxSize;
    }
}
