package leetcodejava.tree;

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
        TreeNode tree = TreeNode.createBinaryTreeByArray(arr, 0);
        List<Integer> list = preOrderTraversal(tree);
        System.out.println(list);
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
        List<Integer> resultList = new ArrayList();
        preOrderHelper(resultList, root);
        return resultList;
    }

    /**
     * 帮助方法
     *
     * @param resultList 链表
     * @param root       根节点
     */
    public void preOrderHelper(List<Integer> resultList, TreeNode root) {
        resultList.add(root.val);
        if (root.left != null) {
            preOrderHelper(resultList, root.left);
        }
        if (root.right != null) {
            preOrderHelper(resultList, root.right);
        }
    }

    /**
     * 线序遍历二叉树（先进先出）
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> preOrderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> resultList = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            resultList.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return resultList;
    }
}

