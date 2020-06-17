package leetcodejava.tree;

import org.junit.Test;

/**
 * This is the solution of No.297 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *  序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SerializeDeserializeBinaryTree297 {

    @Test
    public void serializeDeserializeBinaryTreeTest() {
        Integer[] arr = {1, 2, 3, null, null, 4, 5};
        TreeNode treeNode = TreeNode.createBinaryTreeByArray(arr, 0);
        String serialize = serialize(treeNode);
        System.out.println(serialize);
    }


    /**
     * 序列化树
     * @param root 二叉树
     * @return 字符串
     */
    public String serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        if (root == null) {
            return "#";
        }
        //先序遍历序列化二叉树。
        s.append(String.valueOf(root.val));
        s.append(',');
        //递归序列化左子树。
        s.append(serialize(root.left));
        s.append(',');
        //递归序列化右子树。
        s.append(serialize(root.right));
        return s.toString();
    }

    /**
     * 字符串转成二叉树
     * @param data 数据
     * @return 二叉树
     */
    public TreeNode deserialize(String data) {
        TreeNode root = new TreeNode(0);
        //递归反序列化字符串。
        rebuild(root, 0, data, 0);
        return root.left;
    }

    public int rebuild(TreeNode root, int tag, String s, int start) {
        int length = s.length();
        int index = start;
        //从开始位置遍历找到第一个逗号的位置。
        for (; index < length; index++) {
            if (s.charAt(index) == ',') {
                break;
            }
        }
        //截到第一个逗号前的字符串作为当前需要反序列化的字符串。
        String curr = s.substring(start, index);
        //先序遍历反序列化。
        if (!curr.equals("#")) {
            TreeNode node = new TreeNode(Integer.parseInt(curr));
            // tag 为 0 挂到左子树，为 1 挂到右子树。
            if (tag == 0) {
                root.left = node;
            } else {
                root.right = node;
            }
            // 先递归反序列化完左子树，再递归反序列化右子树。
            if (index < length - 1) {
                index = rebuild(node, 0, s, index + 1);
            }
            if (index < length - 1) {
                index = rebuild(node, 1, s, index + 1);
            }
        }
        return index;
    }
}
