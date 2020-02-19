package leetcodejava.tree;

import java.util.*;

/**
 * 中序遍历二叉树
 *
 * @author: zhangyu
 */
public class BinaryTreeInorderTraversal94 {

    /**
     * 中序遍历二叉树
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helper(list, root);
        return list;
    }

    /**
     * 递归帮助类
     *
     * @param list 存储链表
     * @param root 根节点
     */
    public void helper(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            helper(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            helper(list, root.right);
        }
    }


    /**
     * 中序遍历二叉树
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                p = node.right;
            }
        }
        return list;
    }
}
