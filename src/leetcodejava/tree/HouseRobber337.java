package leetcodejava.tree;

/**
 * 抢到盗窃
 *
 * @author: zhangyu
 */
public class HouseRobber337 {
    /**
     * 找出抢劫最大结果
     *
     * @param root 根节点
     * @return 最大值
     */
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 帮助方法
     *
     * @param node 节点
     * @return 数组
     */
    public int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        if (node.left == null && node.right == null) {
            return new int[]{node.val, 0};
        }
        int[] l = helper(node.left);
        int[] r = helper(node.right);
        return new int[]{node.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])};
    }

    /**
     * 找出抢劫最大结果
     *
     * @param root 根节点
     * @return 最大值
     */
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.left != null) {
            val += rob2(root.left.left) + rob2(root.left.right);
        }
        if (root.right != null) {
            val += rob2(root.right.left) + rob2(root.right.right);
        }
        return Math.max(val + root.val, rob2(root.left) + rob2(root.right));
    }
}
