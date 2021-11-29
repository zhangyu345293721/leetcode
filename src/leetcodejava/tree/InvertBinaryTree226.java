package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * This is the solution of No. 226 problem in the LeetCode,
 * the website of the problem is as follow:
 * ttps://leetcode-cn.com/problems/invert-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the root of a binary tree, invert the tree, and return its root.
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *  
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class InvertBinaryTree226 {

    @Test
    public void invertBinaryTreeTest() {
        Integer[] arr = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        TreeNode result = invertTree(root);
        Assert.assertEquals(result.val, 2);
    }

    /**
     * 反转一棵二叉树
     *
     * @param root 根节点
     * @return 反转后的二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 反转一棵二叉树
     *
     * @param root 根节点
     * @return 反转后的二叉树
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.poll();
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
            TreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = temp;
        }
        return root;
    }
}
