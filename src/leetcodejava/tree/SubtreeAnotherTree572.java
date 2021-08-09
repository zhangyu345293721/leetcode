package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.572 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/subtree-of-another-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SubtreeAnotherTree572 {

    @Test
    public void subtreeAnotherTreeTest() {
        TreeNode t1 = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3});
        TreeNode t2 = TreeNode.createBinaryTreeByArray(new Integer[]{1, 2, 3});
        boolean result = isSubtree(t1, t2);
        System.out.println(result);
        Assert.assertEquals(result, true);
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
