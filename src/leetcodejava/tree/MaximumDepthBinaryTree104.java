package leetcodejava.tree;

import javafx.util.Pair;
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
        int depth = maxDepth(root);
        System.out.println(depth);
        Assert.assertEquals(depth, 3);
    }

    /**
     * 二叉树的最大深度
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 一般的二叉树，都用用到递归的方法
        return (Math.max(maxDepth(root.left), maxDepth(root.right)) + 1);
    }

    /**
     * 二叉树的最大深度
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth2(TreeNode root) {
        // 利用链表的方式，存储键值对
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, currentDepth);
                stack.add(new Pair(root.left, currentDepth + 1));
                stack.add(new Pair(root.right, currentDepth + 1));
            }
        }
        return depth;
    }
}
