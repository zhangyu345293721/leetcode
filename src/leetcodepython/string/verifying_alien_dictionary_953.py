# encoding='utf-8'

'''
/**
 * This is the solution of No.953 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/verifying-an-alien-dictionary
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verifying-an-alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def compare(word1, word2, order):
    '''
        比较字符串
    Args:
        word1: 字符1
        word2: 字符2
        order: 顺序串
    Returns:
        布尔值
    '''
    i = 0
    n1,n2 = len(word1),len(word2)
    while i < n1 and i < n2 and word1[i] == word2[i]:
        i += 1
    if i == n1 or i == n2:
        return n1 < n2
    return order.index(word1[i]) < order.index(word2[i])


def contains_nearby_duplicate(words: List[str], order: str) -> bool:
    '''
        字符串是否按照顺序
    Args:
        words: 字符串数组
        order:  顺序
    Returns:
        布尔值
    '''
    n = len(words)
    for i in range(n - 1):
        flag = compare(words[i], words[i + 1], order)
        if not flag:
            return False
    return True


if __name__ == '__main__':
    words = ["hello", "leetcode"]
    order = "hlabcdefgijkmnopqrstuvwxyz"
    flag = contains_nearby_duplicate(words, order)
    print(flag)
