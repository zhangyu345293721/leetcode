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
     * 将数组构建为二叉树
     *
     * @param array 二维数组
     * @param index 下标
     * @return 二叉树
     */
    public TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            treeNode = new TreeNode(value);
            treeNode.left = createBinaryTreeByArray(array, 2 * index + 1);
            treeNode.right = createBinaryTreeByArray(array, 2 * index + 2);
            return treeNode;
        }
        return treeNode;
    }
}
