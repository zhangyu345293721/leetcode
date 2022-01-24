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
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class HouseRobber337 {

    @Test
    public void houseRobberTest() {
        Integer[] arr = {3, 2, 3, null, 3, null, 1};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        int result = rob(root);
        System.out.println(result);
        Assert.assertEquals(result, 7);
    }

    /**
     * 找出抢劫最大结果
     *
     * @param root 根节点
     * @return 最大值
     */
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 帮助方法
     *
     * @param node 节点
     * @return 数组
     */
    public int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        if (node.left == null && node.right == null) {
            return new int[]{node.val, 0};
        }
        int[] l = helper(node.left);
        int[] r = helper(node.right);
        return new int[]{node.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])};
    }

    /**
     * 找出抢劫最大结果
     *
     * @param root 根节点
     * @return 最大值
     */
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左右子树的子树节点值
        int val = 0;
        if (root.left != null) {
            val += rob2(root.left.left) + rob2(root.left.right);
        }
        if (root.right != null) {
            val += rob2(root.right.left) + rob2(root.right.right);
        }
        // 比较左右子树的值和与节点和左右子树的子树和大小
        return Math.max(val + root.val, rob2(root.left) + rob2(root.right));
    }
}
