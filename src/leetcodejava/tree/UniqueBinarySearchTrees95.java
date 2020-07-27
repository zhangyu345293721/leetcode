package leetcodejava.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No.95 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 * 提示：
 *
 * 0 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class UniqueBinarySearchTrees95 {

    @Test
    public void uniqueBinarySearchTreesTest() {
        int n = 5;
        List<TreeNode> treeNodes = generateTrees(n);
        System.out.println(treeNodes);
    }

    /**
     * 生成二叉树
     *
     * @param n 节点个数
     * @return 链表
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    /**
     * @param start 开始位置
     * @param end   结束位置
     * @return 链表
     */
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTree = generateTrees(start, i - 1);
            List<TreeNode> subRightTree = generateTrees(i + 1, end);
            for (TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
