# encoding='utf-8'
import datetime

'''
判断某个日期是一年中第多少天？
author:zhangyu
date:2020.2.11
'''


def day_of_year(date: str) -> int:
    '''
        计算一年中为第多少天
    Args:
        date: 日期
    Returns:
        一年中的第多少天
    '''
    dd = datetime.datetime.strptime(date, "%Y-%m-%d")
    return dd.timetuple().tm_yday


def day_of_year3(date: str) -> int:
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
    if is_leep(int(year)):
        day_months[2] += 1
        for i in range(int(month)):
            days += day_months[i]
    else:
        for i in range(int(month)):
            days += day_months[i]
    days += int(day)
    return days


def is_leep(year: int) -> bool:
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
    num = day_of_year(date)
    print(num)
