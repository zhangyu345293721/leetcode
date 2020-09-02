# -*- coding:utf-8 -*-
'''
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
'''
import datetime


def day_of_the_week(day: int, month: int, year: int) -> str:
    '''
        判断一天是星期几？
    Args:
        day:天
        month:月
        year:年
    Returns:
        年字符串
    '''
    lis = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
    dic = dict(enumerate(lis))
    w = datetime.date(year, month, day)
    return dic[w.weekday()]


if __name__ == '__main__':
    y, m, d = 2020, 2, 8
    day_of_week = day_of_the_week(d, m, y)
    print(day_of_week)
