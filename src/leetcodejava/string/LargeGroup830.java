package leetcodejava.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.830 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/positions-of-large-groups
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 *
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 *
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 *
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 *
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LargeGroup830 {

    @Test
    public void fun() {
        String str = "abcdddeeeeaabbbcd";
        List<List<Integer>> list = largeGroupPositions(str);
        System.out.println(list);
    }

    /**
     * 最大的分组下标
     *
     * @param S 输入字符串
     * @return 最大下标链表
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        if (S == null || S.length() < 1) {
            return new ArrayList<>();
        }
        int i = 0;
        List<List<Integer>> totalList = new ArrayList<>();
        while (i < S.length() - 1) {
            int start = i;
            int count = 1;
            while (start < S.length() - 1 && S.charAt(start) == S.charAt(start + 1)) {
                count++;
                start++;
            }
            if (count >= 3) {
                List<Integer> positionList = new ArrayList<>();
                positionList.add(i);
                positionList.add(start);
                totalList.add(positionList);
            }
            i = start + 1;
        }
        return totalList;
    }
}
