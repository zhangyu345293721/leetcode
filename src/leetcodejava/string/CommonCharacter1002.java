package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No.1002 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-common-characters
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CommonCharacter1002 {
    @Test
    public void commonCharacterTest() {
        String[] words = {"cool", "lock", "cook"};
        List<String> result = commonChars(words);
        System.out.println(result);
        Assert.assertEquals(result.size(), 2);
    }

    /**
     * 计算重复字符
     *
     * @param words 单词数组
     * @return result
     */
    public List<String> commonChars(String[] words) {
        if (words.length < 1) {
            return new ArrayList<>();
        }
        if (words.length == 1) {
            return Arrays.asList(String.valueOf(words[0].charAt(0)));
        }
        List<String> result = new ArrayList<>();
        char[] chs = words[0].toCharArray();
        for (char ch : chs) {
            boolean flag = true;
            String chStr = String.valueOf(ch);
            for (int i = 1; i < words.length; i++) {
                if (words[i].contains(chStr)) {
                    words[i] = words[i].replaceFirst(chStr, "A");
                } else {
                    flag = false;
                }
            }
            if (flag) {
                result.add(chStr);
            }
        }
        return result;
    }
}
