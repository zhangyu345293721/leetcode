# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 46 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


def translate_num(num: int) -> int:
    '''
        计算统计次数
    Args:
        num: 数字
    Returns:
        返回种数
    '''
    s = str(num)
    if len(s) < 2:
        return 1
    arr = [0] * (len(s))
    arr[0] = 1
    arr[1] = 2 if (0 < int(s[0]) and int(s[0]) < 2) or (int(s[0]) == 2 and int(s[1]) <= 5) else 1
    for i in range(2, len(s)):
        if int(s[i - 1]) > 2 or int(s[i - 1]) == 0 or (int(s[i - 1]) == 2 and int(s[i]) > 5):
            arr[i] = arr[i - 1]
        else:
            arr[i] = arr[i - 1] + arr[i - 2]
    return arr[len(s) - 1]


if __name__ == '__main__':
    num = 12258
    way = translate_num(num)
    print(way)
