package leetcodejava.tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * This is the solution of No.144 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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

