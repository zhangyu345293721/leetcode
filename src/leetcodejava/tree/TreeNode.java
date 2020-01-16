package leetcodejava.tree;

/**
 * 二叉树类
 *
 * @author: zhangyu
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }


    /**
     * 构建二叉树
     *
     * @param array 二维数组
     * @param index 下标
     * @return 二叉树
     */
    public TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }
}
