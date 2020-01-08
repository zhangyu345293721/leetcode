package leetcode.java.math;


import org.junit.Test;

/**
 * 学生出席计算
 *
 * @author: zhangyu
 */
public class StudentAttendance551 {

    @Test
    public void checkRecordDemo() {
        String s = "ALLAPPL";
        boolean b = checkRecord(s);
        System.out.println(b);
    }

    /**
     * @param s 需要校验的字符串   A：Absent P:Present L:Late
     * @return 布尔值
     */
    public boolean checkRecord(String s) {
        if (s.length() < 2) {
            return true;
        }
        char[] chs = s.toCharArray();
        if (s.length() == 2 && chs[0] == 'A' && chs[0] == chs[1]) {
            return false;
        }
        int count = 0;
        for (int i = 1; i < chs.length - 1; i++) {
            if (chs[i] == 'L' && chs[i] == chs[i + 1] && chs[i] == chs[i - 1]) {
                return false;
            }
        }
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'A') {
                count += 1;
            }
        }
        if (count > 1) {
            return false;
        }
        return true;
    }

    /**
     * @param s 需要校验的字符串   A：Absent P:Present L:Late
     * @return 布尔值
     */
    public boolean checkRecord2(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        if (s.contains("LLL")) {
            return false;
        }
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }
        return true;
    }
}
