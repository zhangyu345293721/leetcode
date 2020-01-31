package leetcodejava.string;

import org.junit.Test;

/**
 * 字符串排序
 *
 * @author: zhangyu
 */
public class ExcelSheetColumnNumber171 {

    @Test
    public void testExcelSheetColumnNumber() {
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
