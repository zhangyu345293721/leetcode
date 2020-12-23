# encoding='utf-8'
import datetime

'''
/**
 * This is the solution of No. 1154 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/day-of-the-year
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 *
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 *
 * 输入：date = "2004-03-01"
 * 输出：61
 *  
 * 提示：
 *
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def day_of_year(self, date: str) -> int:
        '''
            计算一年中为第多少天
        Args:
            date: 日期
        Returns:
            一年中的第多少天
        '''
        dd = datetime.datetime.strptime(date, "%Y-%m-%d")
        return dd.timetuple().tm_yday

    def day_of_year3(self, date: str) -> int:
        '''
            计算一年中为第多少天
        Args:
            date: 日期
        Returns:
            一年中的第多少天
        '''
        year, month, day = date.split('-')
        days = 0
        day_months = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        if self.is_leep(int(year)):
            day_months[2] += 1
            for i in range(int(month)):
                days += day_months[i]
        else:
            for i in range(int(month)):
                days += day_months[i]
        days += int(day)
        return days

    def is_leep(self, year: int) -> bool:
        '''
            判断是不是闰年
        Args:
            year: 年
        Returns:
            布尔值
        '''
        return (year % 4 == 0 and year % 100 != 0) or year % 400 == 0


if __name__ == '__main__':
    date = '2020-2-11'
    solution = Solution()
    num = solution.day_of_year(date)
    assert num == 42
