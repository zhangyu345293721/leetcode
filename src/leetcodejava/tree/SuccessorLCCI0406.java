package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.04.06 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/successor-lcci
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 * 通过次数21,221提交次数35,822
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SuccessorLCCI0406 {

    @Test
    public void successorLCCITest() {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        TreeNode result = inorderSuccessor(root, new TreeNode(2));
        System.out.println(result);
        Assert.assertEquals(result.val, 4);
    }

    /**
     * 中序遍历
     *
     * @param root 二叉树
     * @param p    节点
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList();
        searchHelper(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) == p.val) {
                return new TreeNode(result.get(i + 1));
            }
        }
        return null;
    }

    /**
     * 中序遍历
     */
    public void searchHelper(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            searchHelper(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            searchHelper(root.right, result);
        }
    }

    private Boolean comming = false;
    private TreeNode successor = null;

    /**
     * 中序遍历
     *
     * @param root 二叉树
     * @param p    节点
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        inorder(root, p);
        return successor;
    }

    /**
     * 中序遍历
     *
     * @param root 二叉树
     * @param p    节点
     */
    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        inorder(root.left, p);
        if (comming == true) {
            successor = root;
            comming = false;
            return;
        }
        if (root == p) {
            comming = true;
        }
        inorder(root.right, p);
    }
}

