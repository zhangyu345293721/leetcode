package leetcodejava.tree;

/**
 * 二叉树的直径
 *
 * @author: zhangyu
 */
public class DiameterBinaryTree543 {

    private int max = 0;

    /**
     * 求最大直径
     *
     * @param root 根节点
     * @return 最大直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }

    /**
     * 最大直径
     *
     * @param root 根节点
     * @return 最大直径
     */
    private int helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = root.left == null ? 0 : helper(root.left) + 1;
        int right = root.right == null ? 0 : helper(root.right) + 1;
        max = Math.max(left + right, max);
        return Math.max(left, right);
    }
}
