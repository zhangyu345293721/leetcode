package leetcodejava.top100likedquestions;

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
