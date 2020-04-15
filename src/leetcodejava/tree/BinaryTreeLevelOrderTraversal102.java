package leetcodejava.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 *
 * @author: zhangyu
 */
public class BinaryTreeLevelOrderTraversal102 {
    @Test
    public void binaryTreeLevelOrderTraversalTest() {
        TreeNode treeNode = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3, 4, 5}, 0);
        List<List<Integer>> list = levelOrder(treeNode);
        System.out.println(list);
    }

    /**
     * 二叉树层次遍历
     *
     * @param root 根节点
     * @return 返回遍历链表
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        helper(res, root, 0);
        return res;
    }

    /**
     * 递归遍历
     *
     * @param res    结果链表
     * @param root   根节点
     * @param height 高度
     */
    public void helper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.val);
        helper(res, root.left, height + 1);
        helper(res, root.right, height + 1);
    }

    /**
     * 二叉树层次遍历
     *
     * @param root 根节点
     * @return 返回遍历链表
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                list.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
