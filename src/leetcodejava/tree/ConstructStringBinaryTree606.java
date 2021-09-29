package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 606 problem in the book <i>Coding Interviews: Questions, Analysis & Solutions</i>,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 * <p>
 * 输入: 二叉树: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ConstructStringBinaryTree606 {
    @Test
    public void constructStringBinaryTreeTest() {
        Integer[] arr = {1, 2, 3, null, 4};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        String str = tree2str(root);
        System.out.println(str);
        Assert.assertEquals(str,"1(2()(4))(3)");
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
