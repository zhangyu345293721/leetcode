package leetcode.java.array;

import org.junit.Test;

import java.util.Calendar;

/**
 * 任何一天是星期
 *
 * @author: zhangyu
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
