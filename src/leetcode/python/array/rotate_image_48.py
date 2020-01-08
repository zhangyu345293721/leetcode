# encoding='utf-8'

'''
   author:zhangyu
   date:2019.8.30
   description:按照要求旋转矩阵
'''


def swap(matrix, x1, y1, x2, y2):
    temp = matrix[x1][y1]
    matrix[x1][y1] = matrix[x2][y2]
    matrix[x2][y2] = temp


def rotate(matrix):
    if matrix == None or len(matrix) < 1:
        return
    for i in range(len(matrix) - 1):
        j = i
        while j < len(matrix[0]):
            swap(matrix, i, j, j, i)
            j += 1


if __name__ == '__main__':
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            print(matrix[i][j], end=' ')
        print()
    rotate(matrix)
    print('==================================================')
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            print(matrix[i][j], end=' ')
        print()
