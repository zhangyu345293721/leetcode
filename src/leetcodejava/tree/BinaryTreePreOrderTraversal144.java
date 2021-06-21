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
        List<Integer> list = preOrderTraversal(tree);
        System.out.println(list);
        Assert.assertEquals(list.size(), 2);
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
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}

