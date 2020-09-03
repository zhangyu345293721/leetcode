# encoding='utf-8'

'''
/**
 * This is the solution of No. 647 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/palindromic-substrings
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


def count_substrings(a: str) -> int:
    '''
         计算一个字符串中，它的子字符串包含多少回文串
    Args:
        a: 字符串
    Returns:
         子字符串个数
    '''
    global num
    num = 0
    for n in range(len(a)):
        count_sub(a, n, n);
        count_sub(a, n, n + 1);
    return num


def count_sub(a: str, start: int, end: int):
    '''
        计算该字符串是不是回文串
    Args:
        a: 字符串
        start: 开始位置
        end:   结束位置
    Returns:
        None
    '''
    global num
    while start >= 0 and end < len(a) and a[start] == a[end]:
        start -= 1
        end += 1
        num += 1


if __name__ == '__main__':
    a = "aabc"
    num = count_substrings(a)
    print(num)
