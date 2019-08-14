# encoding='utf-8'
'''
    author:zhangyu
    date:2019.7.23
    description:计算约瑟夫环问题
'''


def joseph_problem(number_n, start_number_k, number_m):
    joseph_arr = []
    for i in range(1, number_n + 1):
        joseph_arr.append(i)
    # print(joseph_arr)
    start = start_number_k
    length = len(joseph_arr)

    for j in range(length - 1):
        start = (start + number_m) % len(joseph_arr)
        joseph_arr.pop(start)
    return joseph_arr[0]


if __name__ == '__main__':
    last_number = joseph_problem(1000, 5, 13)
    print(last_number)