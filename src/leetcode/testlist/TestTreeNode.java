package leetcode.testlist;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class TestTreeNode {
    @Test
    public void fun() {
        TreeNode root = new TreeNode(4);
        root = root.left;
        root.left = new TreeNode(7);
        root = root.right;
        root.right = new TreeNode(2);
    }

    /**
     * 反转二叉树
     *
     * @param root 根节点
     * @return 树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        System.out.println(root.val);
        return root;
    }
}
