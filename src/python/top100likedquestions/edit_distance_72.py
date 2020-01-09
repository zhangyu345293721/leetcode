# encoding='utf-8'

'''
   author:zhangyu
   date:2020.1.9
   description:编辑得到最小步数
'''



def min_distance(word1, word2):
    '''
        得到最小步数
    Args:
        word1: 字符串1
        word2:字符串2
    Returns:
        最小步数
    '''
    m = len(word1)
    n = len(word2)
    if m * n == 0:
        return n + m
    d = [[0] * (m + 1)] * (n + 1)
    for i in range(m + 1):
        d[i][0] = i
    for j in range(n + 1):
        d[0][j] = j
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            left = d[i - 1][j] + 1
            down = d[i][j - 1] + 1
            left_down = d[i - 1][j - 1]
            if word1[i - 1] != word2[j - 1]:
                left_down += 1
            d[i][j] = min(left, min(down, left_down))
    return d[n][m]

if __name__ == '__main__':
    word1 = "horse"
    word2 = "ros"
    min_distance = min_distance(word1, word2)
    print(min_distance())
