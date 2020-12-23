# encoding='utf-8'

'''
/**
 * This is the solution of No. 394 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/decode-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''


class Solution:
    def decode_string(self, s: str) -> str:
        '''
            解析字符串
        Args:
            s: 字符串
        Returns:
            解析后的字符串
        '''
        i = 0
        n = len(s)
        sb = []
        while i < n:
            idx = s.index('[', i)
            if idx == -1:
                sb.append(s[i:])
                break
            while s[i] < '0' or s[i] > '9':
                sb.append(s[i])
                i += 1
            length = int(s[i:idx])
            count = 1
            i = idx + 1
            while count != 0:
                if s[i] == '[':
                    count += 1
                if s[i] == ']':
                    count -= 1
                i += 1
            sub = self.decode_string(s[idx + 1:i - 1])
            for k in range(length):
                sb.append(sub)
        return ''.join(sb)


if __name__ == '__main__':
    s = "3[a]2[bc]"
    solution = Solution()
    result = solution.decode_string(s)
    print(result)
