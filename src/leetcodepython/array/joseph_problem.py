# encoding='utf-8'
'''
    author:zhangyu
    date:2019.7.23
    description:计算约瑟夫环问题
'''


def joseph_problem(number_n:int, start_number_k:int, number_m:int)->int:
    '''
        约瑟夫问题
    Args:
        number_n: 多少人
        start_number_k: 开始位置
        number_m: 多少次

    Returns:
        最后一个编号
    '''
    joseph_arr = []
    for i in range(1, number_n + 1):
        joseph_arr.append(i)
    start = start_number_k
    length = len(joseph_arr)

    for j in range(length - 1):
        start = (start + number_m) % len(joseph_arr)
        joseph_arr.pop(start)
    return joseph_arr[0]


if __name__ == '__main__':
    last_number = joseph_problem(1000, 5, 13)
    print(last_number)