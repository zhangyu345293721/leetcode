package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.437 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/path-sum-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PathSum437 {

    @Test
    public void pathSunTest() {
        Integer[] arr = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        int sum = 8;
        int i = pathSum(root, sum);
        System.out.println(i);
        Assert.assertEquals(i, 3);
    }

    /**
     * 求二叉树中路径为固定值的种数
     *
     * @param root 根节点
     * @param sum  和
     * @return 种数
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    /**
     * @param root 根节点
     * @param sum  固定和
     * @return
     */
    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);
        return res;
    }

    int pathNumber = 0;

    /**
     * 求二叉树中路径为固定值的种数
     *
     * @param root 根节点
     * @param sum  和
     * @return 种数
     */
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Sum(root, sum);
        pathSum2(root.left, sum);
        pathSum2(root.right, sum);
        return pathNumber;
    }

    /**
     * 路径和为
     *
     * @param root 根节点
     * @param sum  目标和
     */
    public void Sum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            pathNumber++;
        }
        Sum(root.left, sum);
        Sum(root.right, sum);
    }
}
