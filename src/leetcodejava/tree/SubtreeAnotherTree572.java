package leetcodejava.tree;

import org.junit.Test;

/**
 * This is the solution of No.98 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/validate-binary-search-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SubtreeAnotherTree572 {

    @Test
    public void subtreeAnotherTreeTest() {
        TreeNode t1 = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3});
        TreeNode t2 = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3});
        boolean flag = isSubtree(t1, t2);
        System.out.println(flag);
    }

    /**
     * 判断一棵树是不是另一颗的子树
     *
     * @param s 二叉树s
     * @param t 二叉树t
     * @return 布尔值
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s.val == t.val && isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 判断两棵树是不是一样
     *
     * @param t1 节点1
     * @param t2 节点2
     * @return 布尔值
     */
    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
        } else {
            return false;
        }
    }
}
