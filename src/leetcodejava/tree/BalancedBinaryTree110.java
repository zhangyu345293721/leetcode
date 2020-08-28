package leetcodejava.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No.110 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/balanced-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BalancedBinaryTree110 {

    @Test
    public void balancedBinaryTreeTest() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode binaryTreeByArray = TreeNode.createBinaryTreeByArray(arr, 0);
        boolean balanced = isBalanced(binaryTreeByArray);
        System.out.println(balanced);
    }

    /**
     * 判断二叉树是否是平衡二叉树
     *
     * @param root 根节点
     * @return 布尔值
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isBalanced(root.right) && isBalanced(root.left) && Math.abs(maxDeep(root.left) - maxDeep(root.right)) <= 1;
        }
    }

    /**
     * 获取某个节点的最大深度
     *
     * @param root 根节点
     * @return 最大深度
     */
    private int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
        }
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 判断某个树是不是平衡二叉树
     *
     * @param root 根节点
     * @return 平衡二叉树
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 计算树的深度
     *
     * @param root 根节点
     * @return 深度
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (map.containsKey(root)) {
                return map.get(root);
            }
            int height = Math.max(height(root.left), height(root.right)) + 1;
            map.put(root, height);
            return height;
        }
    }
}
