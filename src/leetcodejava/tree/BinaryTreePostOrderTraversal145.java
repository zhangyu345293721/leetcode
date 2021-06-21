package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.145 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BinaryTreePostOrderTraversal145 {

    @Test
    public void postOrderTraversalTest() {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3, 4, 5, 6});
        List<Integer> postOrderList = postOrderTraversal(root);
        System.out.println(postOrderList);
        Assert.assertEquals((int) postOrderList.get(0), 4);
    }

    /**
     * 后序遍历递归方式
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> postOrderList = new ArrayList<>();
        helper(postOrderList, root);
        return postOrderList;
    }

    /**
     * 后续遍历帮助方法
     *
     * @param postOrderList 链表
     * @param root          根节点
     */
    private void helper(List<Integer> postOrderList, TreeNode root) {
        if (root.left != null) {
            helper(postOrderList, root.left);
        }
        if (root.right != null) {
            helper(postOrderList, root.right);
        }
        postOrderList.add(root.val);
    }

    /**
     * 后序遍历非递归方式
     *
     * @param root 根节点
     * @return 链表
     */
    public List<Integer> postOrderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new LinkedList<>();
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
