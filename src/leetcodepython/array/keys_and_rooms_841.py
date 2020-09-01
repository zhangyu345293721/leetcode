# -*- coding:utf-8 -*-
'''
author:zhangyu
date:2020/8/31
'''

from typing import List

visit = None
num = None


def can_visit_all_rooms(rooms: List[List[int]]) -> bool:
    '''
        是否访问所有房间
    Args:
       nums: 房子钥匙数组
    Returns:
        布尔值
    '''
    n = len(rooms)
    global num
    global visit
    num = 0
    visit = [False for i in range(n)]
    dfs(rooms, 0)
    return num == n


def dfs(rooms: List[List[int]], x: int) -> None:
    '''
        深度优先遍历
    Args:
        rooms: 房间
        x: index
    Returns:
        None
    '''
    global visit
    global num
    visit[x] = True
    num += 1
    for index in rooms[x]:
        if not visit[index]:
            dfs(rooms, index)


def can_visit_all_rooms2(rooms: List[List[int]]) -> bool:
    '''
        是否访问所有房间
    Args:
       nums: 房子钥匙数组
    Returns:
        布尔值
    '''
    num, n = 0, len(rooms)
    visit = [False for i in range(n)]
    visit[0] = True
    room_list = [0]
    while room_list:
        room_id = room_list.pop()
        num += 1
        for key_index in rooms[room_id]:
            if not visit[key_index]:
                room_list.append(key_index)
                visit[key_index] = True
    return num == n


if __name__ == '__main__':
    arr = [[1], [2], [3], []]
    flag = can_visit_all_rooms(arr)
    print(flag)
