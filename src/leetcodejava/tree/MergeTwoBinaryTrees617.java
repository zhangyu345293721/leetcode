package leetcodejava.tree;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * 合并两颗二叉树
 *
 * @author: zhangyu
 */
public class MergeTwoBinaryTrees617 {
    @Test
    public void testMergeTwoBinaryTrees() {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        TreeNode t1 = TreeNode.createBinaryTreeByArray(arr1, 0);
        TreeNode t2 = TreeNode.createBinaryTreeByArray(arr2, 0);
        TreeNode node = mergeTrees2(t1, t2);
        BinaryTreeLevelOrderTraversal102 b = new BinaryTreeLevelOrderTraversal102();
        List<List<Integer>> lists = b.levelOrder(node);
        System.out.println(lists);
    }

    /**
     * 合并两颗二叉树
     *
     * @param t1 二叉树t1
     * @param t2 二叉树t2
     * @return 合并后二叉树
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees1(t1.left, t2.left);
        t1.right = mergeTrees1(t1.right, t2.right);
        return t1;
    }

    /**
     * 合并二叉树
     *
     * @param t1 二叉树t1
     * @param t2 二叉树t2
     * @return 合并后二叉树
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null) {
            return t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }
}
