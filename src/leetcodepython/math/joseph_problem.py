# encoding='utf-8'
'''
/**
 * description:已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。从编号为1的人开始报数，数到m的那个人出列；
 * 他的下一个人又从1开始报数，数到m的那个人又出列；依此规律重复下去，直到圆桌周围的人全部出列。（也类似于变态杀人狂问题）
 * 通常解决这类问题时我们把编号从0~n-1，最后结果+1即为原问题的解。通常，我们会要求输出最后一位出列的人的序号。
 * 那么这里主要研究的是最后一个出列的人的序号要怎么确定。
 *
 * @author: zhangyu
 * @date: 2021/1/7
 */
'''


class Solution:

    def last_remaining(self, n: int, m: int) -> int:
        '''
            约瑟夫问题
        Args:
            k: 多少人
            m: 第几个
        Returns:
            最后一个编号
        '''
        last = 0
        for i in range(2, n + 1):
            last = (last + m) % i
        return last

    def last_remaining2(self, n: int, m: int) -> int:
        '''
            约瑟夫问题
        Args:
            k: 多少人
            m: 第几个
        Returns:
            最后一个编号
        '''
        peoples = []
        for i in range(n):
            peoples.append(i)
        index = 0
        while len(peoples) != 1:
            index = (index + m - 1) % len(peoples)
            peoples.pop(index)
        return peoples[0]


if __name__ == '__main__':
    solution = Solution()
    last_number = solution.last_remaining2(7, 3)
    print(last_number)
    assert last_number == 3
