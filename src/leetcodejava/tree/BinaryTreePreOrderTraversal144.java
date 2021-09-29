package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.144 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BinaryTreePreOrderTraversal144 {

    @Test
    public void binaryTreePreOrderTraversalTest() {
        Integer[] arr = {1, null, 2, 3};
        TreeNode tree = TreeNode.createBinaryTreeByArray(arr);
        List<Integer> result = preOrderTraversal(tree);
        System.out.println(result);
        Assert.assertEquals(result.size(), 2);
    }

    /**
     * 前序遍历二叉树
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList();
        preOrderHelper(result, root);
        return result;
    }

    /**
     * 帮助方法
     *
     * @param result 链表
     * @param root   根节点
     */
    public void preOrderHelper(List<Integer> result, TreeNode root) {
        result.add(root.val);
        if (root.left != null) {
            preOrderHelper(result, root.left);
        }
        if (root.right != null) {
            preOrderHelper(result, root.right);
        }
    }

    /**
     * 先序遍历二叉树（后进先出）
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> preOrderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            result.add(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return result;
    }


    /**
     * 先序遍历二叉树（后进先出）
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> preOrderTraversal3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<SFrame> stack = new Stack<>();
        stack.push(new SFrame(1, root));
        while (!stack.isEmpty()) {
            if (stack.peek().status == 1) {
                result.add(stack.peek().node.val);
                stack.peek().status = 2;
                if (stack.peek().node.left != null) {
                    stack.push(new SFrame(1, stack.peek().node.left));
                }
            } else if (stack.peek().status == 2) {
                stack.peek().status = 3;
                if (stack.peek().node.right != null) {
                    stack.push(new SFrame(1, stack.peek().node.right));
                }
            } else if (stack.peek().status == 3) {
                stack.pop();
            }
        }
        return result;
    }


    private class SFrame {
        int status;
        TreeNode node;

        /**
         * 建立一个栈帧
         *
         * @param status 标志位
         * @param node   元素
         */
        public SFrame(int status, TreeNode node) {
            this.status = status;
            this.node = node;
        }
    }
}

