package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 105 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ConstructBinaryTreeTraversal105 {
    @Test
    public void constructBinaryTreeTraversalTest() {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode node = buildTree(preOrder, inOrder);
        System.out.println(node.val);
        Assert.assertEquals(node.val, 3);
    }

    /**
     * 构建二叉树
     *
     * @param preOrder 前序数组
     * @param inOrder  中序数组
     * @return 根节点
     */
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return myBuildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * preorder下标i,j；inorder下标p,q
     *
     * @param preOrder 前序遍历
     * @param i        位置i
     * @param j        位置j
     * @param inOrder  中序遍历结果
     * @param p        位置p
     * @param r        位置r
     * @return 二叉树
     */
    private TreeNode myBuildTree(int[] preOrder, int i, int j, int[] inOrder, int p, int r) {
        if (i > j) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[i]);
        // 在中序遍历结果inOrder中，查询preOrder[i]所在的位置[p, q-1] q [q+1, r]
        int q = p;
        while (inOrder[q] != preOrder[i]) {
            q++;
        }
        int leftTreeSize = q - p; //左⼦树⼤⼩
        // 构建左⼦树
        TreeNode leftNode = myBuildTree(preOrder, i + 1, i + leftTreeSize, inOrder, p, q - 1);
        // 构建右⼦树
        TreeNode rightNode = myBuildTree(preOrder, i + leftTreeSize + 1, j, inOrder, q + 1, r);
        // 根据root、左⼦树、右⼦树构建树
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
