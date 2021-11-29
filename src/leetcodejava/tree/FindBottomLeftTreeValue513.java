package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No. 513 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *  
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindBottomLeftTreeValue513 {

    @Test
    public void maximumWidthBinaryTreeTest() {
        Integer[] nums = {1, 2, 3, 4, null, 5, 6, null, null, 7};
        TreeNode root = TreeNode.createBinaryTreeByArray(nums);
        int width = findBottomLeftValue1(root);
        System.out.println(width);
        Assert.assertEquals(width, 5);
    }

    /**
     * 底部左边值
     *
     * @param root 根节点
     * @return 最左边值
     */
    public int findBottomLeftValue1(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int result = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                result = p.val;
                if (p.right != null) {
                    queue.add(p.right);
                }
                if (p.left != null) {
                    queue.add(p.left);
                }
            }
        }
        return result;
    }
}
