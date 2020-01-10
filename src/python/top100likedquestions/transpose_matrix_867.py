# encoding='utf-8'

'''
   author:zhangyu
   date:2020.1.11
   description:转置二维数组
'''


def transpose(arr):
    '''
        转置二维数组
    Args:
        arr: 二维数组
    Returns:
        转置后的数组
    '''
    return zip(*arr)



def transpose(arr):
    '''
        转置二维数组
    Args:
        arr: 二维数组
    Returns:
        转置后的数组
    '''
    m,n=len(arr[0]),len(arr)
    new_arr=[[0*m]*n]
    for i in range(len(arr)):
        for j in range(arr[0]):
            new_arr[j][i]=arr[i][j]
    return new_arr