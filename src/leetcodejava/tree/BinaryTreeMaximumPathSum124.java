package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.124 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BinaryTreeMaximumPathSum124 {

    @Test
    public void binaryTreeMaximumPathSumTest() {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode treeNode = TreeNode.createBinaryTreeByArray(arr);
        int totalSum = maxPathSum(treeNode);
        System.out.println(totalSum);
        Assert.assertEquals(totalSum,17);
    }

    private int result = Integer.MIN_VALUE;

    /**
     * 对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
     * 1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
     * 2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
     *
     * @param root 跟节点
     * @return 最大路径
     */
    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return result;
    }

    /**
     * 获取最大值
     *
     * @param root 节点
     * @return 最大值
     */
    private int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int left = Math.max(0, getMaxPath(root.left));
        int right = Math.max(0, getMaxPath(root.right));
        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        result = Math.max(result, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
