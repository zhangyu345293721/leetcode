package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.889 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 *  pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * 示例：
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 *  
 * 提示：
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ConstructBinaryTreePreorderPostorderTraversal889 {

    @Test
    public void constructBinaryTreePreorderPostorderTraversalTest() {
        int[] pre = {1, 2, 4, 5, 3, 6, 7}, post = {4, 5, 2, 6, 7, 3, 1};
        TreeNode result = constructFromPrePost(pre, post);
        System.out.println(result);
        Assert.assertEquals(result.val, 1);
    }

    /**
     * @param pre  前序遍历
     * @param post 后续遍历
     * @return 构造TreeNode
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return myBuildTree(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    /**
     * pre下标i,j；post下标p,r
     *
     * @param pre  前序
     * @param i    位置i
     * @param j    位置j
     * @param post 后续遍历
     * @param p    位置i
     * @param r    位置r
     * @return 二叉树
     */
    private TreeNode myBuildTree(int[] pre, int i, int j, int[] post, int p, int r) {
        if (i > j) {
            return null;
        }
        TreeNode root = new TreeNode(pre[i]);
        if (i == j) {
            return root;
        }//注意这⼀⾏跟前⾯⼏题不⼀样

        // 在post中，查询pre[i+1]所在的位置q，[p, q] [q+1, r-1] r(root)
        int q = p;
        while (post[q] != pre[i + 1]) {
            q++;
        }
        //左⼦树⼤⼩
        int leftTreeSize = q - p + 1;
        // 构建左⼦树
        TreeNode leftNode = myBuildTree(pre, i + 1, i + leftTreeSize, post, p, q);
        // 构建右⼦树
        TreeNode rightNode = myBuildTree(pre, i + leftTreeSize + 1, j, post, q + 1, r - 1);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
