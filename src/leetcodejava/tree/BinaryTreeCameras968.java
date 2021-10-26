package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.968 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 * 示例 1：
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BinaryTreeCameras968 {

    @Test
    public void binaryTreeCamerasTest() {
        TreeNode root = TreeNode.createBinaryTreeByArray(new Integer[]{0, 0, null, 0, 0});
        int result = minCameraCover(root);
        System.out.println(result);
        Assert.assertEquals(result, 1);
    }

    private int ans = 0;

    /**
     * 计算需要相机个数
     *
     * @param root 根节点
     * @return 返回相机个数
     */
    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (searchHelper(root) == 2) {
            ans++;
        }
        return ans;
    }

    /**
     * 1：该节点安装了监视器 2：该节点可观，但没有安装监视器 3：该节点不可观
     *
     * @param node 节点
     * @return 数量
     */
    private int searchHelper(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int left = searchHelper(node.left), right = searchHelper(node.right);
        if (left == 2 || right == 2) {
            ans++;
            return 0;
        } else if (left == 0 || right == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * 计算需要相机个数
     *
     * @param root 根节点
     * @return 返回相机个数
     */
    public int minCameraCover2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] array = dfs(root);
        return array[1];
    }

    /**
     * 深度优先遍历
     *
     * @param root 根节点
     * @return 深度优先遍历
     */
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }
}
