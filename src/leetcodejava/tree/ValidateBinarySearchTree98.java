package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * This is the solution of No.98 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/validate-binary-search-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ValidateBinarySearchTree98 {

    @Test
    public void validateBinarySearchTreeTest() {
        Integer[] nums = {2, 1, 3};
        TreeNode root = TreeNode.createBinaryTreeByArray(nums);
        boolean result = isValidBST2(root);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    long pre = Long.MIN_VALUE;

    /**
     * 判断一棵树是不是二叉搜索数
     *
     * @param root 根节点
     * @return 布尔值
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    /**
     * 判断一棵树是不是二叉搜索数 中序遍历是升序
     *
     * @param root 根节点
     * @return 布尔值
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
