# encoding='utf-8'

'''
/**
 * This is the solution of No.541 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-string-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg" 
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
import re


class Solution:

    def get_reverse_string(self, s: str, k: int) -> str:
        '''
            字符串反转
        Args:
            arr: 字符串
        Returns:
            反转后字符串
        '''
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

    def get_reverse_string2(self, s: str, k: int) -> str:
        '''
            字符串反转
        Args:
            arr: 字符串
        Returns:
            反转后字符串
        '''
        if len(s) <= k:
            return s[::-1]
        if len(s) > k and len(s) <= 2 * k:
            temp_str = s[0: k]
            return temp_str[::-1] + s[k:len(s)]
        if len(s) > 2 * k:
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
        return '-1'

    def cut_text(self, text: str, length: int) -> str:
        '''
            截取固定长度的字符串
        Args:
            text: 字符串
            length: 长度
        Returns:
            字符串
        '''
        textArr = re.findall('.{' + str(length) + '}', text)
        textArr.append(text[(len(textArr) * length):])
        return textArr

    def get_reverse_str(self, arr):
        '''
            字符串反转
        Args:
            arr: 字符串
        Returns:
            反转后字符串
        '''
        s = ''
        for i in range(len(arr)):
            if i % 2 == 0:
                s += arr[i][::-1]
            else:
                s += arr[i]
        return s

    def get_reverse_string3(self, s: str, k: int) -> str:
        '''
            字符串反转
        Args:
            arr: 字符串
        Returns:
            反转后字符串
        '''
        if len(s) < k:
            return s[::-1]
        i = 0
        length = len(s)
        str_list = list(s)
        while i < length:
            start, end = i, min(i + k - 1, length - 1)
            while start < end:
                temp = str_list[start]
                str_list[start] = str_list[end]
                str_list[end] = temp
                start += 1
                end -= 1
            i += 2 * k
        return ''.join(str_list)


if __name__ == '__main__':
    s = 'abc'
    solution = Solution()
    reversed_s = solution.get_reverse_string3(s, 2)
    print(reversed_s)
    assert reversed_s == 'bac'
