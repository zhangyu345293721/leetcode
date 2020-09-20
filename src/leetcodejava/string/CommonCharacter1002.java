package leetcodejava.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No. 1002 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-common-characters
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CommonCharacter1002 {
    @Test
    public void commonCharacterTest() {
        String[] strs = {"cool", "lock", "cook"};
        List<String> list = commonChars(strs);
        System.out.println(list);
    }

    /**
     * 计算重复字符
     *
     * @param A 数组
     * @return list
     */
    public List<String> commonChars(String[] A) {
        if (A.length < 1) {
            return new ArrayList<>();
        }
        if (A.length == 1) {
            return Arrays.asList(A[0].split(""));
        }
        List<String> list = new ArrayList<>();
        char[] chs = A[0].toCharArray();
        for (char ch : chs) {
            boolean flag = true;
            String chStr = String.valueOf(ch);
            for (int i = 1; i < A.length; i++) {
                if (A[i].contains(chStr)) {
                    A[i] = A[i].replaceFirst(chStr, "\\.");
                } else {
                    flag = false;
                }
            }
            if (flag) {
                list.add(chStr);
            }
        }
        return list;
    }
}
