package leetcodejava.array;

import org.junit.Test;

import java.util.Calendar;

/**
 * This is the solution of No. 1185 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/day-of-the-week
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * 示例 1：
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 *
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 *
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DayoftheWeek1185 {


    @Test
    public void testDayoftheWeek() {
        int day = 15;
        int month = 8;
        int year = 1993;
        String str = dayOfTheWeek(day, month, year);
        System.out.println(str);
    }

    /**
     * 输入一天是星期几
     *
     * @param day   天
     * @param month 月
     * @param year  年
     * @return
     */
    public String dayOfTheWeek(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        cal.set(year, month - 1, day);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }
}
