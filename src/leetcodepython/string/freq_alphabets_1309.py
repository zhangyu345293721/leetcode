# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 1309 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * <p>
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 * <p>
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 * <p>
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 * <p>
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

'''


def get_char(sub_str: str) -> chr:
    '''
        对字符串进行转换
    Args:
        sub_str: 输入字符串
    Returns:
        转换后字符
    '''
    if sub_str.__contains__('#'):
        sub = sub_str[:-1]
        num = int(sub)
        return chr(num + 96)
    return chr(int(sub_str) + 96)


def freqAlphabets(s: str) -> str:
    '''
        字符串转化
    Args:
        s: 输入字符串
    Returns:
        返回解析后字符串
    '''
    i = 0
    result_str = []
    while i < len(s):
        if i + 2 < len(s) and s[i + 2] == '#':
            sub_str = s[i: i + 3]
            ch = get_char(sub_str)
            result_str.append(ch)
            i += 3
        else:
            ch = get_char(s[i])
            result_str.append(ch)
            i += 1
    return ''.join(result_str)


if __name__ == '__main__':
    s = "25#"
    result = freqAlphabets(s)
    print(result)
