package leetcodejava.tree;

import org.junit.Test;

/**
 * This is the solution of No.938 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/range-sum-of-bst
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RangeSumBST938 {
    private int ans;

    @Test
    public void testRangeSumBST() {
        Integer[] arr = {10, 5, 15, 3, 7, null, 18};
        TreeNode t = TreeNode.createBinaryTreeByArray(arr, 0);
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
