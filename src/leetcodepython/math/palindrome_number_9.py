# encoding='utf-8'

'''
/**
 * This is the solution of No. 9 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/palindrome-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


def is_palindrome(num: int) -> int:
    '''
        判断一个数是不是回文串
    Args:
        num: 数字
    Returns:
        回文串
    '''
    if num < 0:
        return False
    reverse = 0
    temp = num
    while num != 0:
        reverse = 10 * reverse + num % 10
        num = num // 10
    return reverse == temp

def is_palindrome2(num: int) -> int:
    '''
        判断一个数是不是回文串
    Args:
        num: 数字
    Returns:
        回文串
    '''
    temp=str(num)[::-1]
    return temp==str(num)
if __name__ == '__main__':
    num = 121
    flag = is_palindrome2(num)
    s=str(123)
    print(flag)