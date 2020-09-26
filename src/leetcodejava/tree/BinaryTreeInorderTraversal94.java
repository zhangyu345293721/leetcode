package leetcodejava.tree;

import org.junit.Test;

import java.util.*;

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
        System.out.println(list);
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
     * 递归帮助类
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
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            resultList.add(root.val);
            root = root.right;
        }
        return resultList;
    }
}
