package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No.113 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/path-sum-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 * @date: 2020/9/26
 */
public class PathSum113 {

    @Test
    public void pathSumTest() {
        Integer arr[] = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        int sum = 22;
        List<List<Integer>> result = pathSum(root, sum);
        System.out.println(result);
        Assert.assertEquals((int) result.get(0).get(0), 5);
    }

    /**
     * 深度优先遍历查找所有路径和为固定数
     *
     * @param root 根节点
     * @param sum  和
     * @return result结果
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSumHelper(root, sum, path, result);
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param root 根节点
     * @param sum  总和
     */
    public void pathSumHelper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            pathSumHelper(root.left, sum, path, result);
        }
        if (root.right != null) {
            pathSumHelper(root.right, sum, path, result);
        }
        path.remove(path.size() - 1);
    }
}
