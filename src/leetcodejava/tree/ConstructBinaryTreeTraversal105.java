package leetcodejava.tree;

import org.junit.Test;

/**
 * 根据前序和中序还原二叉树
 *
 * @author: zhangyu
 */
public class ConstructBinaryTreeTraversal105 {
    @Test
    public void testConstructBinaryTreeTraversal() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = buildTree(preorder, inorder);
    }

    /**
     * 构建二叉树
     *
     * @param preorder 前序数组
     * @param inorder  中序数组
     * @return 根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * 还原二叉树帮助类
     *
     * @param preStart 前序开始位置
     * @param inStart  中序开始位置
     * @param inEnd    中序结束位置
     * @param preorder 前序数组
     * @param inorder  中序数组
     * @return 根节点
     */
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
