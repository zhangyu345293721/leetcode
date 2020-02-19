package leetcodejava.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
     * 前序遍历二叉树
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}

