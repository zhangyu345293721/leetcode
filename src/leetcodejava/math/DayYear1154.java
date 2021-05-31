package leetcodejava.math;


import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * This is the solution of No. 1154 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/day-of-the-year
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 * <p>
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 * <p>
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 * <p>
 * 输入：date = "2004-03-01"
 * 输出：61
 *  
 * 提示：
 * <p>
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DayYear1154 {
    @Test
    public void dayYearTest() {
        String date = "2020-02-11";
        int daysOfYear = dayOfYear2(date);
        System.out.println("daysOfYear = " + daysOfYear);
        Assert.assertEquals(daysOfYear, 42);
    }

    /**
     * 每年天数
     *
     * @param date 日期
     * @return 数字
     */
    public int dayOfYear(String date) {
        if (date == null || date.length() < 1) {
            return 01;
        }
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        LocalDate d = LocalDate.of(year, month, day);
        return d.getDayOfYear();
    }

    /**
     * 每年天数
     *
     * @param date 日期
     * @return 数字
     */
    public int dayOfYear2(String date) {
        if (date == null || date.length() < 1) {
            return 01;
        }
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int days = calendar.get(Calendar.DAY_OF_YEAR);
        return days;
    }

    /**
     * 日期是一年中的多少天
     *
     * @param date 日期
     * @return number
     */
    public int dayOfYear3(String date) {
        if (date == null || date.length() < 1) {
            return -1;
        }
        String[] dates = date.split("-");
        int year = Integer.valueOf(dates[0]);
        int month = Integer.valueOf(dates[1]);
        int day = Integer.valueOf(dates[2]);
        int days = 0;

        int[] dayOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeap(year)) {
            // 闰年2月29天
            dayOfMonths[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            days += dayOfMonths[i];
        }
        return days + day;
    }

    /**
     * 判断是否是闰年
     *
     * @param year 输入年
     * @return 返回布尔值
     */
    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}