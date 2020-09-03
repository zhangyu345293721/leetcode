# encoding='utf-8'

'''
/**
 * This is the solution of No.96 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/unique-binary-search-trees
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
import  numpy as np
def num_trees(n: int) -> int:
    dp = np.zeros(n+1)
    dp[0] = 1
    for i in range(1, n + 1):
        l, r, count = 0, i - 1, 0
        while i < r:
            count += dp[l] * dp[r]
            l += 1
            r -= 1
        count *= 2
        if l == r:
            count += dp[l] * dp[l]
        dp[i] = count
    return dp[n]


if __name__ == '__main__':
    num=3
    result = num_trees(3)
    print(result)
