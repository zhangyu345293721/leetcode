# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.offer 841 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/keys-and-rooms
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''

from typing import List

visit = None
num = None


class Solution:

    def can_visit_all_rooms(self, rooms: List[List[int]]) -> bool:
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
        self.dfs(rooms, 0)
        return num == n

    def dfs(self, rooms: List[List[int]], x: int) -> None:
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
                self.dfs(rooms, index)

    def can_visit_all_rooms2(self, rooms: List[List[int]]) -> bool:
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
    solution = Solution()
    flag = solution.can_visit_all_rooms(arr)
    print(flag)
    assert flag == True
