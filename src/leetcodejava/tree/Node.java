package leetcodejava.tree;

/**
 * @author: zhangyu
 * @date: 2020/9/28
 */
public class Node {
    /**
     * 每个节点固定值
     */
    int val;
    /**
     * 左子树节点
     */
    Node left;
    /**
     * 右子树节点
     */
    Node right;
    /**
     * 下一个节点
     */
    Node next;

    public Node(int val) {
        this.val = val;
    }

    /**
     * 将数组构建为树
     *
     * @param array 二维数组
     * @return 树
     */
    public static Node createTreeByArray(Integer[] array) {
        return createTreeByArray(array, 0);
    }

    /**
     * 将数组构建为树
     *
     * @param array 二维数组
     * @param index 下标
     * @return 二叉树
     */
    public static Node createTreeByArray(Integer[] array, Integer index) {
        if (index == null) {
            index = 0;
        }
        Node node = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            node = new Node(value);
            node.left = createTreeByArray(array, 2 * index + 1);
            node.right = createTreeByArray(array, 2 * index + 2);
            return node;
        }
        return node;
    }
}
