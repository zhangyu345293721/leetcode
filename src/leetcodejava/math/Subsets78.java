package leetcodejava.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.78 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/subsets
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Subsets78 {
    @Test
    public void subsetsTest() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }


    /**
     * 子集
     *
     * @param nums 数组
     * @return 子集
     */
    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        subsets(nums, 0, subList, result);
        return result;
    }

    /**
     * 找出一个数组的所有子集
     *
     * @param nums    数组
     * @param i       下标
     * @param subList 子集
     * @param list    链表
     */
    private void subsets(int[] nums, int i, List<Integer> subList, List<List<Integer>> list) {
        if (i == nums.length) {
            list.add(subList);
            return;
        }
        int num = nums[i];
        List<Integer> temp = new ArrayList<>(subList);
        temp.add(num);
        subsets(nums, i + 1, temp, list);
        subsets(nums, i + 1, subList, list);
    }

    /**
     * 数组生成所有的子集
     *
     * @param nums 数组
     * @return 链表
     */
    private List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        int[] pos = new int[nums.length];
        int index = 0;
        pos[0] = -1;
        while (index >= 0) {
            pos[index]++;
            if (pos[index] < nums.length) {
                List<Integer> s = new ArrayList<Integer>();
                for (int ii = 0; ii <= index; ii++) {
                    s.add(nums[pos[ii]]);
                }
                ret.add(s);
                if (index < nums.length - 1) {
                    index++;
                    pos[index] = pos[index - 1];
                }
                continue;
            }
            index--;
        }
        ret.add(new ArrayList());
        return ret;
    }

    /**
     * 数组生成所有的子集
     *
     * @param nums 数组
     * @return 链表
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = result.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}
