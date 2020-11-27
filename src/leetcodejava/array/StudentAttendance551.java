package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 551 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/student-attendance-record-i
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "PPALLL"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class StudentAttendance551 {

    @Test
    public void checkRecordTest() {
        String s = "ALLAPPL";
        boolean b = checkRecord(s);
        Assert.assertEquals(b, false);
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
