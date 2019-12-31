package leetcode.select;


import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * 计算那一天是一年中的第几天
 *
 * @author: zhangyu
 */
public class DayYear1154 {
    @Test
    public void dayYearTestDemo() {
        String date = "2019-02-10";
        int daysOfYear = dayOfYear2(date);
        System.out.println("daysOfYear = " + daysOfYear);
    }

    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        LocalDate d = LocalDate.of(year, month, day);
        return d.getDayOfYear();
    }

    public int dayOfYear2(String date) {
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int days = calendar.get(Calendar.DAY_OF_YEAR);
        return days;
    }
}
