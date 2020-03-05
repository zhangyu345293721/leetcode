# encoding='utf-8'

'''
解析字符串
author:zhangyu
date:2020.3.4
'''


def decode_string(s: str) -> str:
    '''
        解析字符串
    Args:
        s: 字符串
    Returns:
        解析后的字符串
    '''
    i = 0
    n = len(s)
    sb = []
    while i < n:
        idx = s.index('[',i)
        if idx == -1:
            sb.append(s[i:])
            break
        while s[i] < '0' or s[i] > '9':
            sb.append(s[i])
            i += 1
        length = int(s[i:idx])
        count = 1
        i = idx + 1
        while count != 0:
            if s[i] == '[':
                count += 1
            if s[i] == ']':
                count -= 1
            i += 1
        sub = decode_string(s[idx + 1:i - 1])
        for k in range(length):
            sb.append(sub)
    return ''.join(sb)


if __name__ == '__main__':
    s = "3[a]2[bc]"
    result = decode_string(s)
    print(result)
