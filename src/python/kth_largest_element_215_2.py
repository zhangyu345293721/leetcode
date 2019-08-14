# encoding='utf-8'
import queue

'''
   author:zhangyu
   date:2019.8.14
   description:找出第K个大的数
'''


def kth_largest_element_num(arr, k):
    pq = queue.PriorityQueue()
    for ele in arr:
        pq.put(ele)
        if pq.qsize() > k:
            pq.get()
    return pq.get()

if __name__ == '__main__':
    arr = [1, 2, 6, -2, -4, 9, 7, 10, 12]
    k = 3
    num = kth_largest_element_num(arr, k)
    print(num)
