
package leetcodejava.bfsdfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 使用递归在 Java 中实现从给定的 M 个元素中选择 𝑁个非相邻元素的子集，可以按照以下步骤进行。这个方法使用深度优先搜索（DFS）和回溯来生成所有符合条件的子集。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = {1, 2, 3, 4, 5} 和 n = 2
 * 输出：[[1, 3],[1, 4],[1,5],[2, 4],[2, 5],[3, 5]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Subset90 {

    @Test
    public void subsetTest() {
        int[] nums = {1, 2, 3, 4, 5};
        int n = 2;
        List<List<Integer>> subsets = findSubsets(nums, n);
        System.out.println(result);
        Assert.assertEquals(result.size(), 6);
    }
    List<List<Integer>> result = new ArrayList();
  
   /**
    * 数组生成所有的子集
    *
    * @param nums 数组
    * @param n 数量
    * @return 链表
    */
    public static List<List<Integer>> findSubsets(int[] nums, int n) {
        searchHelper(nums, n, 0, new ArrayList<>());
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param nums   数组
     * @param index  数组下标
     * @param subset 临时链表
     */
    private static void searchHelper(int[] nums, int n, int index, List<Integer> subset) {
        if (subset.size() == n) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // search helper dfs
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            searchHelper(nums, n, i + 2, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
