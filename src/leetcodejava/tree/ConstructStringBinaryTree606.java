package leetcodejava.tree;

import org.junit.Test;

/**
 * 通过二叉树构建字符串
 *
 * @author: zhangyu
 */
public class ConstructStringBinaryTree606 {
    @Test
    public void testConstructStringBinaryTree() {

    }

    /**
     * 二叉树转成字符串
     *
     * @param t 二叉树
     * @return 字符串
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        left = left.isEmpty() && right.isEmpty() ? "" : "(" + left + ")";
        right = right.isEmpty() ? "" : "(" + right + ")";
        return t.val + left + right;
    }
}
