package leetcodejava.tree;

/**
 * 二叉树类
 *
 * @author: zhangyu
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }


    /**
     * 将数组构建为二叉树
     *
     * @param array 二维数组
     * @return 二叉树
     */
    public static TreeNode createBinaryTreeByArray(Integer[] array) {
        return createBinaryTreeByArray(array, 0);
    }

    /**
     * 将数组构建为二叉树
     *
     * @param array 二维数组
     * @param index 下标
     * @return 二叉树
     */
    public static TreeNode createBinaryTreeByArray(Integer[] array, Integer index) {
        if (index == null) {
            index = 0;
        }
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
