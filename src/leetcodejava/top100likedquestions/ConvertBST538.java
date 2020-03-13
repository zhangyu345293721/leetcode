package leetcodejava.top100likedquestions;

import leetcodejava.tree.TreeNode;
import org.junit.Test;

/**
 * 转换树
 *
 * @author: zhangyu
 */
public class ConvertBST538 {
    private int sum = 0;

    @Test
    public void testConvertBST() {
        Integer[] arr = {5, 2, 13};
        TreeNode treeNode = new TreeNode();
        TreeNode tree = treeNode.createBinaryTreeByArray(arr, 0);
        System.out.println(tree);
        TreeNode result = convertBST(tree);
        System.out.println(result);
    }

    /**
     * 转换搜索二叉树
     *
     * @param root 根节点
     * @return 输入结果
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
