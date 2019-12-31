package leetcode.select;


import org.junit.Test;

/**
 * 计算那一天是一年中的第几天
 *
 * @author: zhangyu
 */
public class DayYear11542 {
    @Test
    public void dayYearTestDemo() {
        String date = "2019-02-10";
        int daysOfYear = dayOfYear(date);
        System.out.println("daysOfYear = " + daysOfYear);
    }

    /**
     * 日期是一年中的多少天
     *
     * @param date 日期
     * @return number
     */
    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        int year = Integer.valueOf(strs[0]);
        int month = Integer.valueOf(strs[1]);
        int day = Integer.valueOf(strs[2]);
        int days = 0;

        if (isLeep(year)) {
            int[] dayOfMonths = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 0; i < month - 1; i++) {
                days += dayOfMonths[i];
            }
        } else {
            int[] dayOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 0; i < month - 1; i++) {
                days += dayOfMonths[i];
            }
        }
        days += day;
        return days;

    }

    /**
     * 判断是否是闰年
     *
     * @param year 输入年
     * @return 返回布尔值
     */
    private boolean isLeep(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
