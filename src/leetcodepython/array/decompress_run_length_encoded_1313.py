'''
/**
 * This is the solution of No.1313 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 *
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 *
 * 请你返回解压后的列表。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 * 示例 2：
 *
 * 输入：nums = [1,1,2,3]
 * 输出：[1,3,3]
 *  
 * 提示：
 *
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


def decompress_rle_list(nums: List[int]) -> int:
    '''
        解压链表
    Args:
        nums: 数组
    Returns:
        新链表
    '''
    i = 0
    decompress_arr = []
    while i < len(nums) - 1:
        time = nums[i]
        num = nums[i + 1]
        for j in range(time):
            decompress_arr.append(num)
        i += 2
    return decompress_arr


if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    arr = decompress_rle_list(nums);
    print(arr)
