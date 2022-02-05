package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * This is the solution of No. 104 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximumDepthBinaryTree104 {

    @Test
    public void maximumDepthBinaryTreeTest() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        int result = maxDepth2(root);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 二叉树的最大深度
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth1(root.left);
        int rightHeight = maxDepth1(root.right);
        // 一般的二叉树，都用用到递归的方法
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 二叉树的最大深度
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth2(TreeNode root) {
        // 利用链表的方式，存储键值对
        LinkedList<NodePair> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new NodePair(root, 1));
        }
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            NodePair current = queue.pop();
            root = current.node;
            int currentDepth = current.currentDepth;
            if (root.left != null) {
                queue.add(new NodePair(root.left, currentDepth + 1));
            }
            if (root.right != null) {
                queue.add(new NodePair(root.right, currentDepth + 1));
            }
            maxDepth = Math.max(maxDepth, currentDepth);
        }
        return maxDepth;
    }

    /**
     * 辅助pair对
     */
    class NodePair {
        TreeNode node;
        int currentDepth;

        public NodePair(TreeNode node, int currentDepth) {
            this.node = node;
            this.currentDepth = currentDepth;
        }
    }
}
