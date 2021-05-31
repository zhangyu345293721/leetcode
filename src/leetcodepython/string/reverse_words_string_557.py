# encoding='utf-8'

'''
/**
 * This is the solution of No.557 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''

class Solution:

    def reverse_words(self, s: str) -> str:
        '''
            单词反转
        Args:
            arr: 字符串
        Returns:
            反转后字符串
        '''
        res = ''
        length = len(s)
        i = 0
        while i < length:
            start = i
            while i < length and s[i] != ' ':
                i += 1
            for p in range(start, i)[::-1]:
                res += s[p]
            while i < length and s[i] == ' ':
                i += 1
                res += ' '
        return res

    def reverse_words2(self, s: str) -> str:
        '''
            单词反转
        Args:
            arr: 字符串
        Returns:
            反转后字符串
        '''
        strs = s.split(' ')
        res = []
        for sub in strs:
            res.append(sub[::-1])
        return ' '.join(res)

if __name__ == '__main__':
    s = "Let's take LeetCode contest"
    solution = Solution()
    reversed_s = solution.reverse_words(s)
    print(reversed_s)
    assert reversed_s == "s'teL ekat edoCteeL tsetnoc"
