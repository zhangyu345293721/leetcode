package leetcodejava.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 *
 * @author: zhangyu
 */
public class BinaryTree102 {

    /**
     * 二叉树层次遍历
     *
     * @param root 根节点
     * @return 返回遍历链表
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        levelHelper(res, root, 0);
        return res;
    }

    /**
     * 递归遍历
     *
     * @param res    结果链表
     * @param root   根节点
     * @param height 高度
     */
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
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
