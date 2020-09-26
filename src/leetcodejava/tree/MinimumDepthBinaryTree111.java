package leetcodejava.tree;

import org.junit.Test;

/**
 * This is the solution of No.111   problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinimumDepthBinaryTree111 {
    @Test
    public void minimumDepthBinaryTreeTest() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode binaryTreeByArray = TreeNode.createBinaryTreeByArray(arr);
        int num = minDepth(binaryTreeByArray);
        System.out.println(num);
    }

    /**
     * 获取一颗树的最低深度
     *
     * @param root 二叉树
     * @return 最低深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
