# -*- coding:utf-8 -*-
'''
/**
 * This is the solution of No. 171 problem in the book <i>Cracking the Coding Interview</i>,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/excel-sheet-column-number
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


def excel_sheet_column_number(s: str) -> int:
    '''
        字符串变成数字
    Args:
        s:字符串
    Returns:
        数字
    '''
    sum = 0
    for ch in s:
        num = ord(ch) - ord('A') + 1
        sum = sum * 26 + num
    return sum


if __name__ == '__main__':
    string = 'AB'
    arr_str = excel_sheet_column_number(string)
    print(arr_str)
