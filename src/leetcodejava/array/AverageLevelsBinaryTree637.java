package leetcodejava.array;

import leetcodejava.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is the solution of No.637 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AverageLevelsBinaryTree637 {

    @Test
    public void averageLevelsBinaryTreeTest() {
        Integer[] arr = {3, 9, 20, 15, 7};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        List<Double> list = averageOfLevels2(root);
        System.out.println(list);
    }

    /**
     * 二叉树每层平均数（深度优先）
     *
     * @param root 根节点
     * @return 平均数
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        helper(root, 0, counts, sums);
        List<Double> averages = new ArrayList<>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    /**
     * @param root   根节点
     * @param level  深度
     * @param counts 数量
     * @param sums   总和
     */
    public void helper(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        helper(root.left, level + 1, counts, sums);
        helper(root.right, level + 1, counts, sums);
    }

    /**
     * 二叉树每层平均数(广度优先)
     *
     * @param root 根节点
     * @return 平均数
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            averages.add(sum / size);
        }
        return averages;
    }
}
