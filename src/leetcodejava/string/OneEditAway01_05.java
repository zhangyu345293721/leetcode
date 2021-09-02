package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.01.05 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class OneEditAway01_05 {

    @Test
    public void oneEditAwayTest() {
        String first = "ppale";
        String second = "ppale";
        boolean result = oneEditAway(first, second);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 一次编辑能完成
     *
     * @param first  第一个字符串
     * @param second 第二个字符串
     * @return 布尔值
     */
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        boolean edit = false;
        int l1 = first.length();
        int l2 = second.length();
        while (i < l1 && j < l2) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                if (!edit) {
                    if (l1 == l2) {
                        i++;
                        j++;
                    } else if (l1 < l2) {
                        j++;
                    } else {
                        i++;
                    }
                    edit = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
