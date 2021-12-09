package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No.106 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 * @data 2020/9/24
 */
public class ConstructBinaryTree106 {

    @Test
    public void constructBinaryTreeTest() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode);
        Assert.assertEquals(treeNode.val,3);
    }

    int postIdx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    /**
     * 构建二叉树
     *
     * @param inorder   中序数组
     * @param postorder 后续数组
     * @return 构建树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        postIdx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idxMap.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    /**
     * 帮助节点
     *
     * @param inLeft  左边
     * @param inRight 右边
     * @return 二叉树
     */
    public TreeNode helper(int inLeft, int inRight) {
        // 如果这里没有节点构造二叉树了，就结束
        if (inLeft > inRight) {
            return null;
        }

        // 选择 postIdx 位置的元素作为当前子树根节点
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        // 根据 root 所在位置分成左右两棵子树
        int index = idxMap.get(rootVal);

        // 下标减一
        postIdx--;
        // 构造右子树
        root.right = helper(index + 1, inRight);
        // 构造左子树
        root.left = helper(inLeft, index - 1);
        return root;
    }

    /**
     * 构建二叉树
     *
     * @param inorder   中序数组
     * @param postorder 后续数组
     * @return 构建树
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null) {
            return null;
        }
        if (postorder == null) {
            return null;
        }
        return myBuildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * postorder下标i,j；inorder下标p,q
     *
     * @param postorder 后续遍历
     * @param i         位置i
     * @param j         位置j
     * @param inorder   前序遍历
     * @param p         位置p
     * @param r         位置r
     * @return 构造的二叉树
     */
    private TreeNode myBuildTree(int[] postorder, int i, int j, int[] inorder, int p, int r) {
        if (i > j) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[j]);
        // 在中序遍历结果inorder中，查询postorder[j]所在的位置q
        // [p, q-1] q [q+1, r]
        int q = p;
        while (inorder[q] != postorder[j]) {
            q++;
        }
        //左右⼦树⼤⼩
        int leftTreeSize = q - p;
        // 构建左⼦树
        TreeNode leftNode = myBuildTree(postorder, i, i + leftTreeSize - 1, inorder, p, q - 1);
        // 构建右⼦树
        TreeNode rightNode = myBuildTree(postorder, i + leftTreeSize, j - 1, inorder, q + 1, r);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
