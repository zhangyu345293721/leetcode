# encoding='utf-8'

'''
   author:zhangyu
   description:找出最大匹配的符号
   date:2019.8.19
'''


def get_longest_valid_parentheses(strs):
    '''
        找出最大匹配的符号
    Args:
        strs: 字符串数组

    Returns:
        最大匹配符号
    '''
    max_len = 0
    for i in range(len(strs)):
        j = i + 2
        while j <= len(strs):
            if is_valid_parentheses(strs[i:j]):
                max_len = max(max_len, j - i)
            j += 2
    return max_len


def is_valid_parentheses(strs):
    '''
        判断括号是不是匹配的
    Args:
        strs: 字符串
    Returns:
        布尔值
    '''
    stack = list()
    for i in range(len(strs)):
        if strs[i] == '(':
            stack.append('(')
        elif len(stack) != 0 and stack[len(stack) - 1] == '(':
            stack.pop()
        else:
            return False
    return len(stack) == 0


if __name__ == '__main__':
    strs = '()()'
    max_len = get_longest_valid_parentheses(strs)
    print(max_len)
