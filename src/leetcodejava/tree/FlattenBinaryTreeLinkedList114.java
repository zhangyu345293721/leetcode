package leetcodejava.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 将二叉树转成链表
 *
 * @author: zhangyu
 */
public class FlattenBinaryTreeLinkedList114 {

    /**
     * 将二叉树改为链表
     *
     * @root 根节点
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (!stack.isEmpty()) {
                currentNode.right = stack.peek();
            }
            // 左子树要为空
            currentNode.left = null;
        }
    }


    /**
     * 将二叉树改为链表
     *
     * @root 根节点
     */
    public void flatten2(TreeNode root) {
        falttenForList(root, null);
    }

    /**
     * @param root    根节点
     * @param current 当前节点
     * @return 节点
     */
    private TreeNode falttenForList(TreeNode root, TreeNode current) {
        if (root == null) {
            return current;
        }
        current = falttenForList(root.right, current);
        current = falttenForList(root.left, current);
        root.left = null;
        root.right = current;
        return root;
    }
}
