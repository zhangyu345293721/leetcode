package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This is the solution of No. 114 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FlattenBinaryTreeLinkedList114 {

    @Test
    public void flattenBinaryTreeLinkedListTest() {
        Integer[] arr = {1, 2, 5, 3, 4, null, 6};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        flatten(root);
        System.out.println(root);
        Assert.assertEquals(root.val, 1);
    }

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
        flattenForList(root, null);
    }

    /**
     * 将二叉树遍历成链表
     *
     * @param root    根节点
     * @param current 当前节点
     * @return 节点
     */
    private TreeNode flattenForList(TreeNode root, TreeNode current) {
        if (root == null) {
            return current;
        }
        current = flattenForList(root.right, current);
        current = flattenForList(root.left, current);
        root.left = null;
        root.right = current;
        return root;
    }
}
