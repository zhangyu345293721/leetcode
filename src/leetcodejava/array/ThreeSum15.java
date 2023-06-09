package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 15 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/3sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件
 * 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ThreeSum15 {
    @Test
    public void threeSumTest() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
        Assert.assertEquals(result.size(), 2);
    }

    /**
     * 三个值相加和等于固定数
     *
     * @param nums 数组
     * @return 返回list
     */
    private List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(result);
    }
    
     /**
     * 三个值相加和等于0
     *
     * @param nums 数组
     * @return 返回list
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null || nums.length < 1) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i < len; i++) {
            // 过滤重复数字
            if(i > 0 && nums[i] == nums[i - 1] ){
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 过滤重复数字
                    while(j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while(j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
