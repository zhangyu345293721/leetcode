package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.701 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 * 例如, 
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * 或者这个树也是有效的:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 * <p>
 * 提示：
 * <p>
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 * @data 2020/9/30
 */
public class InsertBinarySearchTree701 {
    @Test
    public void insertBinarySearchTreeTest() {
        Integer[] arr = {4, 2, 7, 1, 3, null, null};
        int val = 5;
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        TreeNode result = insertIntoBST2(root, val);
        System.out.println(result.val);
        Assert.assertEquals(result.val, 4);
    }

    /**
     * 遍历向二叉树中加入节点
     *
     * @param root 根节点
     * @param val  固定值
     * @return treeNode
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode parent = root, p = root;
        while (p != null) {
            parent = p;
            p = p.val < val ? p.right : p.left;
        }
        if (parent.val < val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }
        return root;
    }

    /**
     * 递归向平衡二叉树中插入一个节点
     *
     * @param root 根节点
     * @param val  传入的值
     * @return 返回节点
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST2(root.left, val);
        } else {
            root.right = insertIntoBST2(root.right, val);
        }
        return root;
    }
}
