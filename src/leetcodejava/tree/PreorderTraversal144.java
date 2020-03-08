package leetcodejava.tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 二叉树前序遍历
 *
 * @author: zhangyu
 */
public class PreorderTraversal144 {

    /**
     * 前序遍历二叉树
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        helper(list, root);
        return list;
    }

    /**
     * 帮助方法
     *
     * @param list 链表
     * @param root 根节点
     */
    public void helper(List<Integer> list, TreeNode root) {
        list.add(root.val);
        if (root.left != null) {
            helper(list, root.left);
        }
        if (root.right != null) {
            helper(list, root.right);
        }
    }

    /**
     * 层次遍历二叉树
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> traversal(TreeNode root) {
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return list;
    }
}

