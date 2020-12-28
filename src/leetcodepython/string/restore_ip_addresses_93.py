# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No.93 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/restore-ip-addresses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List

result = []
COUNT = 4
segment = [0 for x in range(COUNT)]


class Solution:
    def restore_ip_addresses(self, s: str) -> List[str]:
        '''
            修复ip
        Args:
            s: 字符串
        Returns:
            ip的list
        '''
        global result
        if len(s) < 4 or len(s) > 12:
            return result
        self.search_helper(s, 0, 0)
        return result

    def search_helper(self, s: str, seg_id: int, start: int) -> None:
        '''
            查找帮助类
        Args:
            s: 字符串
            seg_id: 区域id
            start: 开始位置
        Returns:
            None
        '''
        global COUNT
        global segment
        global result
        if seg_id == COUNT:
            if start == len(s):
                result.append('.'.join(segment))
            return
        if start == len(s):
            return

        if s[start] == '0':
            segment[seg_id] = str(0)
            self.search_helper(s, seg_id + 1, start + 1)
        total = 0
        for i in range(start, len(s)):
            total = 10 * total + int(s[i])
            if total > 0 and total <= 255:
                segment[seg_id] = str(total)
                self.search_helper(s, seg_id + 1, i + 1)
            else:
                break


if __name__ == '__main__':
    s = "25525511135"
    solution = Solution()
    result = solution.restore_ip_addresses(s)
    print(result)
    assert result == ['255.255.11.135', '255.255.111.35']
