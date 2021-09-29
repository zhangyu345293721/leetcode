package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 337 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/house-robber-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LowestCommonAncestorBinarySearchTree235 {

    @Test
    public void lowestCommonAncestorBinarySearchTreeTest() {
        Integer[] arr = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode result = lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
        Assert.assertEquals(result.val, 6);
    }

    /**
     * @param root 根节点
     * @param p    节点p
     * @param q    节点q
     * @return 最近公共
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new TreeNode();
        }
        TreeNode res = lowestCommonHelper(root, p, q);
        return res;
    }

    /**
     * 最小公共子树帮助类
     *
     * @param root 根节点
     * @param p    节点p
     * @param q    节点q
     */
    public TreeNode lowestCommonHelper(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonHelper(root.right, p, q);
        } else {
            return lowestCommonHelper(root.left, p, q);
        }
    }
}
