from typing import List

'''
/**
 * This is the solution of No. 912 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sort-an-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
def sort_array(nums: List[int]) -> List[int]:
    '''
        对数组进行排序
    Args:
        nums: 数组
    Returns:
        排序好的数组
    '''
    if len(nums) < 2:
        return nums
    p = nums[len(nums) // 2]
    left = [x for x in nums if x < p]
    middle = [x for x in nums if x == p]
    right = [x for x in nums if x > p]
    return sort_array(left) + middle + sort_array(right)


if __name__ == '__main__':
    nums = [5, 2, 3, 1]
    result = sort_array(nums)
    print(result)
