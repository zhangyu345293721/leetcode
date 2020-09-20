package leetcodejava.string;

import org.junit.Test;

/**
 * This is the solution of No. 171 problem in the book <i>Cracking the Coding Interview</i>,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/excel-sheet-column-number
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ExcelSheetColumnNumber171 {

    @Test
    public void excelSheetColumnNumberTest() {
        String str = "ZY";
        System.out.println(titleToNumber(str));
    }

    /**
     * 字符串排序
     *
     * @param s 字符串
     * @return 数字
     */
    public int titleToNumber(String s) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            int num = ch - 'A'+1;
            sum = 26 * sum + num;
        }
        return sum;
    }
}
