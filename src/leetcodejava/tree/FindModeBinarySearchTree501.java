package leetcodejava.tree;

import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 501 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindModeBinarySearchTree501 {

    @Test
    public void findModeBinarySearchTreeTest() {
        Integer[] arr = new Integer[]{3, 2, 3, 1, 2};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr);
        int[] mode = findMode2(root);
        System.out.println(mode);
    }

    /**
     * 出现最多次数数组
     *
     * @param root 根节点
     * @return 出现最多次数数组
     */
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> frequencyMap = new HashMap();
        if (root == null) {
            return new int[]{};
        }
        helper(root, frequencyMap);
        int maxNum = frequencyMap.values().stream().max(Comparator.comparing(e -> e)).get();
        return frequencyMap.entrySet().stream().filter(e -> e.getValue() == maxNum).mapToInt(e1 -> e1.getKey()).toArray();
    }

    /**
     * 帮助类
     *
     * @param root         根节点
     * @param frequencyMap 传入frequencyMap
     */
    public void helper(TreeNode root, Map<Integer, Integer> frequencyMap) {
        if (root.left != null) {
            helper(root.left, frequencyMap);
        }
        frequencyMap.put(root.val, frequencyMap.getOrDefault(root.val, 0) + 1);
        if (root.right != null) {
            helper(root.right, frequencyMap);
        }
    }

    /**
     * 出现最多次数数组
     *
     * @param root 根节点
     * @return 出现最多次数数组
     */
    public int[] findMode2(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        // result转换为int[]
        int size = result.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    int previousVal = 0, currentTimes = 0, maxTimes = 0;

    /**
     * 二叉搜索树中序遍历是递增顺序
     *
     * @param root 根节点
     */
    public void traversal(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            traversal(root.left, result);
        }
        // 判断当前值与上一个值的关系, 更新 currentTimes 和 previousVal
        if (previousVal == root.val) {
            currentTimes++;
        } else {
            previousVal = root.val;
            currentTimes = 1;
        }
        // 判断当前数量与最大数量的关系, 更新 result 和 maxTimes
        if (currentTimes == maxTimes) {
            result.add(root.val);
        } else if (currentTimes > maxTimes) {
            result.clear();
            result.add(root.val);
            maxTimes = currentTimes;
        }
        if (root.right != null) {
            traversal(root.right, result);
        }
    }
}
