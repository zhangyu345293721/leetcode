package leetcodejava.tree;

/**
 * 二叉树最小祖先
 *
 * @author: zhangyu
 */
public class LowestCommonAncestorBinaryTree236 {

    /**
     * @param root 根节点
     * @param p    节点p
     * @param q    节点q
     * @return 最小相同祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
