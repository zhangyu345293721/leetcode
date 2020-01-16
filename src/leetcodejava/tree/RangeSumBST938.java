package leetcodejava.tree;

import org.junit.Test;

/**
 * 在某个范围内的和
 *
 * @author: zhangyu
 */
public class RangeSumBST938 {
    private int ans;

    @Test
    public void testRangeSumBST() {
        TreeNode treeNode = new TreeNode();
        Integer[] arr = {10, 5, 15, 3, 7, null, 18};
        TreeNode t = treeNode.createBinaryTreeByArray(arr, 0);
        int sum = rangeSumBST(t, 7, 15);
        System.out.println(sum);
    }

    /**
     * @param root 根节点
     * @param L    左边
     * @param R    右边
     * @return 和
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    /**
     * 深度优先遍历
     *
     * @param node 头结点
     * @param L    左边
     * @param R    右边
     */
    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R) {
                ans += node.val;
            }
            if (L < node.val) {
                dfs(node.left, L, R);
            }
            if (node.val < R) {
                dfs(node.right, L, R);
            }
        }
    }
}
