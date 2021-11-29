package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is the solution of No.102 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BinaryTreeLevelOrderTraversal102 {
    @Test
    public void binaryTreeLevelOrderTraversalTest() {
        TreeNode treeNode = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        List<List<Integer>> result = levelOrder((treeNode));
        Assert.assertEquals(result.size(), 3);
    }

    /**
     * 二叉树层次遍历
     *
     * @param root 根节点
     * @return 返回遍历链表
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList();
        levelOrderHelper(res, root, 0);
        return res;
    }

    /**
     * 递归遍历
     *
     * @param res    结果链表
     * @param root   根节点
     * @param height 高度
     */
    public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.val);
        levelOrderHelper(res, root.left, height + 1);
        levelOrderHelper(res, root.right, height + 1);
    }

    /**
     * 二叉树层次遍历
     *
     * @param root 根节点
     * @return 返回遍历链表
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                tempList.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}
