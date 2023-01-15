package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 16.24 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-binary/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 *示例 1:
 *
 *输入: nums = [5,6,5], target = 11
 *输出: [[5,6]]
 *示例 2:
 *
 *输入: nums = [5,6,5,6], target = 11
 *输出: [[5,6],[5,6]]
 *提示：
 * nums.length <= 100000
 *
 *链接：https://leetcode.cn/problems/pairs-with-sum-lcci
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PairNumSum24 {
    @Test
    public void PairNumSumTest() {
        int[] nums = {5,6,5,6};
        List<List<Integer>> result = pairNumSum(nums);
        System.out.println(result);
        Assert.assertEquals(result.size(), 2);
    }

    /**
     * 两个数相加和
     *
     * @param nums 
     * @return 相加字符串
     */
    public String pairNumSum(int [] nums) {
        if( nums == null || nums.length < 1) {
            return new ArrayList();
        }
        // 先对数组进行排序
        Arrays.sort(nums);
        // 定义收尾指针
        int i = 0;
        int j = nums.length - 1;
        List<List<Integer>> result = new ArrayList();
        while(i < j) {
            int sum = nums[i] + nums[j];
            if( sum == target) {
                List<Integer> temp = new ArrayList();
                temp.add(nums[i]);
                temp.add(nums[j]);
                result.add(new ArrayList(temp));
                i++;
                j--;
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
