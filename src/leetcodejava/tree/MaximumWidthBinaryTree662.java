package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No. 104 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximumWidthBinaryTree662 {

    @Test
    public void maximumWidthBinaryTreeTest() {
        Integer[] nums = {1, 3, 2, 5, 2, null, 9};
        TreeNode root = TreeNode.createBinaryTreeByArray(nums);
        int width = widthOfBinaryTree(root);
        Assert.assertEquals(width, 4);
        System.out.println(width);
    }

    /**
     * 树的宽度
     *
     * @param root 根节点
     * @return 宽度
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueIndex = new LinkedList<>();
        queue.add(root);
        queueIndex.add(1);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int initIndex = queueIndex.peek();
            int index = initIndex;
            while (levelSize > 0) {
                TreeNode r = queue.poll();
                index = queueIndex.poll();
                if (r.left != null) {
                    queue.add(r.left);
                    queueIndex.add(index * 2);
                }
                if (r.right != null) {
                    queue.add(r.right);
                    queueIndex.add(index * 2 + 1);
                }
                levelSize -= 1;
            }
            result = Math.max(result, index - initIndex + 1);
        }
        return result;
    }
}
