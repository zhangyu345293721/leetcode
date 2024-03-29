package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.680 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/long-pressed-name
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *  
 *
 * 提示：
 *
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LongPressed925 {
    @Test
    public void longPressedTest() {
        String name = "dfuyalc";
        String typed = "dfuuyallc";
        boolean result = isLongPressedName(name, typed);
        System.out.println("b = " + result);
        Assert.assertEquals(result,true);
    }

    /**
     * 是不是长类型名字
     *
     * @param name  名字
     * @param typed 类型
     * @return 布尔值
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() < 1) {
            return false;
        }
        if (name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1)) {
            return false;
        }
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < name.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                if (j < typed.length()) {
                    j++;
                }
            } else {
                while (typed.charAt(j) == typed.charAt(j - 1)) {
                    j++;
                }
                if (name.charAt(i) != typed.charAt(j)) {
                    return false;
                }
            }
        }
        while (j < typed.length()) {
            if (typed.charAt(j) != name.charAt(i - 1)) {
                return false;
            }
            j++;
        }
        return j == typed.length();
    }
}
