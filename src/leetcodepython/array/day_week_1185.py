# -*- coding:utf-8 -*-
'''
判断一天是星期几
author:zhangyu
date:2020/2/8
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
