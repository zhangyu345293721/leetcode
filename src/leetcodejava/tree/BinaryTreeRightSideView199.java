package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.199 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/binary-tree-right-side-view
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4         <---
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class BinaryTreeRightSideView199 {

    @Test
    public void binaryTreeRightSideViewTest() {
        Integer[] arr = {1, 2, 3, null, 5, null, 4};
        TreeNode treeNode = TreeNode.createBinaryTreeByArray(arr);
        List<Integer> result = rightSideView(treeNode);
        System.out.println(result);
        Assert.assertEquals(result.size(), 3);
    }

    /**
     * 取最右边元素
     *
     * @param root 二叉树
     * @return 最右边元素
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
