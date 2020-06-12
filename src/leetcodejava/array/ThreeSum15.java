package leetcodejava.array;

import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 15 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/3sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ThreeSum15 {
    @Test
    public void testThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4, 0, 0};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }

    /**
     * 三个值相加
     *
     * @param nums 数组
     * @return 返回list
     */
    private List<List<Integer>> threeSum(int[] nums) {
        int flag = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (((nums[i] + nums[j] + nums[k]) == 0) && i < j && j < k && i < k) {
                        if (flag == 0 && isHaveThreeZero(nums[i], nums[j], nums[k])) {
                            addList(list, nums[i], nums[j], nums[k]);
                            flag = 1;
                        }
                        if (isExists(list, nums[i], nums[j], nums[k])) {
                            addList(list, nums[i], nums[j], nums[k]);
                        }
                    }
                }
            }
        }
        return list;
    }

    /**
     * 是否存在该数字
     *
     * @param list 链表
     * @param num1 数字1
     * @param num2 数字2
     * @param num3 数字3
     * @return 布尔值
     */
    private boolean isExists(List<List<Integer>> list, int num1, int num2, int num3) {
        for (List<Integer> l : list) {
            if (l.contains(num1) && l.contains(num2) && l.contains(num3)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 三个数等于0
     *
     * @param num1 数字1
     * @param num2 数字2
     * @param num3 数字3
     * @return 布尔值
     */
    private boolean isHaveThreeZero(int num1, int num2, int num3) {
        if (num1 == 0 && num2 == 0 && num3 == 0) {
            return true;
        }
        return false;
    }

    /**
     * 元素增加到链表中
     *
     * @param list 链表
     * @param num1 数字1
     * @param num2 数字2
     * @param num3 数字2
     */
    private void addList(List<List<Integer>> list, int num1, int num2, int num3) {
        List<Integer> listSum = new ArrayList<>();
        listSum.add(num1);
        listSum.add(num2);
        listSum.add(num3);
        list.add(listSum);
    }

    /**
     * 三个值相加
     *
     * @param nums 数组
     * @return 返回list
     */
    private List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
