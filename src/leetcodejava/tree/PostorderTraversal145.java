package leetcodejava.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历
 *
 * @author: zhangyu
 */
public class PostorderTraversal145 {

    /**
     * 后序遍历递归方式
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
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
    private void helper(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            helper(list, root.left);
        }
        if (root.right != null) {
            helper(list, root.right);
        }
        list.add(root.val);
    }

    /**
     * 后序遍历非递归方式
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            res.add(0, node.val);
        }
        return res;
    }
}
