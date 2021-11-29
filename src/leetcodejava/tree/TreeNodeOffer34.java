package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.572 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/subtree-of-another-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TreeNodeOffer34 {

    @Test
    public void treeNodeOfferTest() {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        List<List<Integer>> result = pathSum(root, 22);
        System.out.println(result);
        Assert.assertEquals(result.size(), 1);
    }

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 从根节点到末尾节点的路径
     *
     * @param root 根节点
     * @param sum  和值
     * @return result
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        dfs(root, sum, new ArrayList<>(), 0);
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param root    头结点
     * @param sum     和
     * @param path    路径
     * @param pathSum 路径和
     */
    private void dfs(TreeNode root, int sum, List<Integer> path, int pathSum) {
        path.add(root.val);
        pathSum += root.val;
        if (root.left == null && root.right == null) {
            if (pathSum == sum) {
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, path, pathSum);
        }
        if (root.right != null) {
            dfs(root.right, sum, path, pathSum);
        }
        path.remove(path.size() - 1);
        // pathSum == root.val 不需要这⼀句
    }
}
