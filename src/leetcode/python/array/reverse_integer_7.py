# encoding='utf-8'

'''
    author:zhangyu
    date:2019.7.25
    description 翻转一个数字
'''


def get_reverse_integer(num):
    '''
        反转数字
    Args:
        num:数字
    Returns:
        反转后数字

    '''
    if num == 0:
        return num
    sum = 0
    while num != 0:
        sum = 10 * sum + num % 10
        num = num // 10
    if int(sum) == sum:
        return sum
    else:
        return 0


def reverse_integer(num):
    '''
      反转数字
  Args:
      num:数字
  Returns:
      反转后数字

  '''
    if num == 0:
        return num
    if num > 0:
        return int(str(num)[::-1])
    else:
        return int('-' + str(num)[1:][::-1])


if __name__ == '__main__':
    number = get_reverse_integer(123459999999999999999)
    print(number)
