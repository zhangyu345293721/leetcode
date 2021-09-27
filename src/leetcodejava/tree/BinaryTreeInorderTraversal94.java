package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This is the solution of No.94 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BinaryTreeInorderTraversal94 {

    @Test
    public void binaryTreeInorderTraversalTest() {
        Integer arr[] = {1, 2, 3, 4, 5, 6};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        List<Integer> list = inorderTraversal2(root);
        Assert.assertEquals(list.size(), 6);
    }

    /**
     * 中序遍历二叉树
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> inorderList = new ArrayList<>();
        inorderHelper(inorderList, root);
        return inorderList;
    }

    /**
     * 递归遍历帮助类
     *
     * @param inorderList 存储链表
     * @param root        根节点
     */
    public void inorderHelper(List<Integer> inorderList, TreeNode root) {
        if (root.left != null) {
            inorderHelper(inorderList, root.left);
        }
        inorderList.add(root.val);
        if (root.right != null) {
            inorderHelper(inorderList, root.right);
        }
    }

    /**
     * 中序遍历二叉树
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            resultList.add(node.val);
            root = node.right;
        }
        return resultList;
    }


    /**
     * 中序遍历二叉树
     *   1）status=1 表示要扩展左⼦树，将左⼦节点⼊栈
     *   2）status=2 表示左⼦树扩展完了，要扩展右⼦树，将右⼦节点⼊栈
     *   3）status=3 表示左右⼦树都扩展完了，出栈
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<SFrame> stack = new Stack<>();
        stack.push(new SFrame(1, root));
        while (!stack.isEmpty()) {
            if (stack.peek().status == 1) {
                stack.peek().status = 2;
                if (stack.peek().node.left != null) {
                    stack.push(new SFrame(1, stack.peek().node.left));
                }
            } else if (stack.peek().status == 2) {
                stack.peek().status = 3;
                result.add(stack.peek().node.val);
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

        public SFrame(int status, TreeNode node) {
            this.status = status;
            this.node = node;
        }
    }
}
