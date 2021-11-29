package leetcodejava.top100likedquestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.17 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LetterCombinationsPhoneNumber17 {
    @Test
    public void letterCombinationsPhoneNumberTest() {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
        Assert.assertEquals(result.get(0), "ad");
    }

    /**
     * 数字到号码的映射
     */
    private String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 路径
     */
    private StringBuilder sb = new StringBuilder();

    /**
     * 结果集
     */
    private List<String> res = new ArrayList<>();

    /**
     * 获取链表长度的list，然后再进行买个遍历
     *
     * @param digits 字符串数组
     * @return list
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    /**
     * 回溯函数
     *
     * @param digits 字符串数字
     * @param index
     */
    private void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String val = map[digits.charAt(index) - '2'];
        for (char ch : val.toCharArray()) {
            sb.append(ch);
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private List<String> result = new ArrayList<>();

    /**
     * 获取链表长度的list，然后再进行买个遍历
     *
     * @param digits 字符串数组
     * @return list
     */
    public List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] mappings = new String[10];
        mappings[2] = "abc";
        mappings[3] = "def";
        mappings[4] = "ghi";
        mappings[5] = "jkl";
        mappings[6] = "mno";
        mappings[7] = "pqrs";
        mappings[8] = "tuv";
        mappings[9] = "wxyz";
        char[] path = new char[digits.length()];
        backtrack(mappings, digits, 0, path);
        return result;
    }

    /**
     * 回溯搜索
     *
     * @param mappings 字典
     * @param digits   字符串
     * @param k        k表示阶段
     * @param path     path路径
     */
    private void backtrack(String[] mappings, String digits, int k, char[] path) {
        if (k == digits.length()) {
            result.add(new String(path));
            return;
        }
        String mapping = mappings[digits.charAt(k) - '0'];
        for (int i = 0; i < mapping.length(); ++i) {
            path[k] = mapping.charAt(i);
            backtrack(mappings, digits, k + 1, path);
        }
    }
}
