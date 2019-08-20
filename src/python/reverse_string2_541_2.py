# encoding='utf-8'

'''
   author:zhangyu
   description: 按照要求反转一个字符串2
   date:2019.8.19
'''


def get_reverse_string(s, k):
        list = []
        sb = ''
        number = len(s) // k
        for i in range(number):
            list.append(s[i * k:i * k + k])
        if number * k < len(s):
            list.append(s[number * k:len(s)])
        for i in range(len(list)):
            if i % 2 == 0:
                sb += list[i][::-1]
            else:
                sb += list[i]
        return sb

if __name__ == '__main__':
    s = 'abc'
    revese_s = get_reverse_string(s, 2)
    print(revese_s)
