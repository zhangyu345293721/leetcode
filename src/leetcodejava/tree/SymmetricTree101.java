package leetcodejava.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No.101 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/symmetric-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SymmetricTree101 {

    @Test
    public void symmetricTreeTest() {
        Integer[] nums = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNode.createBinaryTreeByArray(nums);
        boolean symmetric = isSymmetric2(root);
        System.out.println(symmetric);

    }

    /**
     * 判断该二叉树是不是对称的
     *
     * @param root 二叉树
     * @return 布尔值
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.right, root.left);
    }

    /**
     * 帮助类
     *
     * @param t1 t1
     * @param t2 t2
     * @return 布尔值
     */
    private boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }

    /**
     * 判断该二叉树是不是对称的
     *
     * @param root 二叉树
     * @return 布尔值
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
