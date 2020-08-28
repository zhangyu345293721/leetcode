# encoding='utf-8'

'''
判断括号是否匹配问题
author:zhangyu
date:2020.8.14
'''


def is_valid(s: str) -> bool:
    """
        判断括号是否匹配
    Args:
        s:括号字符串
    Returns:
        布尔值
    """
    if len(s) % 2 == 1:
        return False
    stack = []
    for ch in s:
        if ch == '[' or ch == '(' or ch == '{':
            stack.append(ch)
        elif ch == ']':
            if not stack or stack.pop() != '[':
                return False
        elif ch == ')':
            if not stack or stack.pop() != '(':
                return False
        else:
            if not stack or stack.pop() != '{':
                return False
    return not stack


def is_valid2(s: str) -> bool:
    """
        判断括号是否匹配
    Args:
        s:括号字符串
    Returns:
        布尔值
    """
    stack = []
    for ch in s:
        if ch == '[':
            stack.append(']')
        elif ch == '(':
            stack.append(')')
        elif ch == '{':
            stack.append('}')
        elif not stack or ch != stack.pop():
            return False
    return not stack


if __name__ == '__main__':
    a = '()'
    num = is_valid2(a)
    print(num)
