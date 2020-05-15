'''
对一个数进行开方
author:zhangyu
'''

def my_sqrt(x: int) -> int:
    '''
        被除数
    Args:
        x: 除数
    Returns:
        开方数
    '''
    return int(x ** 0.5)


def my_sqrt_2(x: int) -> int:
    '''
        被除数
    Args:
        x: 除数
    Returns:
        开方数
    '''
    if x <= 1:
        return x
    num = 1
    while num * num <= x:
        num += 1
    return num - 1


if __name__ == '__main__':
    num = 8
    result = my_sqrt_2(num)
    print(result)
