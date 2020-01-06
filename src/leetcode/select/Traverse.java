package leetcode.select;

import leetcode.testlist.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 二叉树的遍历
 *
 * @author zhangyu
 **/


public class Traverse {

    /**
     * .前序递归遍历
     *
     * @param root root节点
     */
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    /**
     * 前序非递归遍历
     *
     * @param root 根节点
     */
    public void preOrderTraverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            System.out.println(p.val);
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }
        }
    }

    /**
     * 中序递归遍历
     *
     * @param root 根节点
     */
    public void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.println(root.val);
            inOrderTraverse(root.right);
        }
    }

    /**
     * 中序非递归遍历
     *
     * @param root 根节点
     */
    public void inOrderTraverse2(TreeNode root) {
        // 如果树为空，直接退出
        if (root == null) {
            return;
        }
        // 如果不是添加到栈中
        Stack<TreeNode> stack = new Stack<>();
        // 如果栈一直不为空就一直循环
        while (!stack.isEmpty()) {
            // 定义一个变量接收栈中元素
            TreeNode p = stack.pop();
            // 如果左子树不为空，直接保存到栈中
            if (p.left != null) {
                stack.push(p.left);
            }
            // 如果栈顶不为空，直接输出
            System.out.println(p.val);
            // 如果右子树不为空，直接保存到栈中
            if (p.right != null) {
                stack.push(p.right);
            }
        }
    }

    /**
     * 后序递归遍历
     *
     * @param root 根节点
     */
    public void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.println(root.val);
        }
    }


    /**
     * 后序非递归遍历 (弄懂后序排序非递归)
     *
     * @param root 根节点
     */
    public void postOrderTraverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur;
        TreeNode pre = null;
        s.push(root);
        while (!s.isEmpty()) {
            cur = s.pop();
            // 两种情况打印根节点:1.它的左子树和右子树为空；2.前驱节点不为空，且前驱节点是当前节点的左子树或者右子树
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.println(cur.val);
                s.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    s.push(cur.right);
                }
                if (cur.left != null) {
                    s.push(cur.left);
                }
            }
        }
    }

    /**
     * 层次遍历非递归 （层次遍历把栈换成队列）
     *
     * @param root 根节点
     */
    public void levelTraverse(TreeNode root) {
        if (root != null) {
            return;
        }
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            System.out.println(p.val);
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }
    }
}
