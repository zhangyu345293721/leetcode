package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.offer33 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *  
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 * 提示：
 * <p>
 * 数组长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TreeSearchOffer33 {

    @Test
    public void treeSearchOfferTest() {
        int[] postorder = {1, 6, 3, 2, 5};
        boolean result = verifyPostorder(postorder);
        System.out.println(result);
        Assert.assertEquals(result,false);
    }

    /**
     * 验证后续遍历
     *
     * @param postorder 后续遍历结果
     * @return 布尔值
     */
    public boolean verifyPostorder(int[] postorder) {
        return myVerify(postorder, 0, postorder.length - 1);
    }

    /**
     * 验证后续遍历
     *
     * @param postorder 后续
     * @param i         位置i
     * @param j         位置j
     * @return 布尔值
     */
    private boolean myVerify(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        // postorder[j]是根节点,先分离出左⼦树[i, k-1]
        int k = i;
        while (k < j && postorder[k] < postorder[j]) {
            k++;
        }
        // 验证[k, j-1]满⾜有⼦树的要求，都⼤于postorder[j]
        int p = k;
        while (p < j) {
            if (postorder[p] < postorder[j]) {
                return false;
            }
            p++;
        }
        // 递归验证左右⼦树是否满⾜BST的要求
        boolean leftValid = myVerify(postorder, i, k - 1);
        if (leftValid == false) {
            return false;
        }
        boolean rightValid = myVerify(postorder, k, j - 1);
        return rightValid;
    }
}
