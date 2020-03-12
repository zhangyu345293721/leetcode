package leetcodejava.tree;

/**
 * 路径和为固定值
 *
 * @author: zhangyu
 */
public class PathSum437 {

    /**
     * 求二叉树中路径为固定值的种数
     *
     * @param root 根节点
     * @param sum  和
     * @return 种数
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    /**
     * @param root 根节点
     * @param sum  固定和
     * @return
     */
    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);
        return res;
    }
}
