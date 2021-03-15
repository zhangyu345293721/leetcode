package leetcodejava.top100likedquestions;

import leetcodejava.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.538 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * 来源：力扣（LeetCode）
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ConvertBST538 {

    @Test
    public void convertBSTTest() {
        Integer[] arr = {5, 2, 13};
        TreeNode tree = TreeNode.createBinaryTreeByArray(arr);
        TreeNode result = convertBST(tree);
        Assert.assertEquals(result.val, 18);
    }
    private int sum = 0;
    /**
     * 转换搜索二叉树
     *
     * @param root 根节点
     * @return 输入结果
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
