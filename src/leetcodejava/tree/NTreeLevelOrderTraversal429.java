package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 337 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/house-robber-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class NTreeLevelOrderTraversal429 {

    @Test
    public void nTreeLevelOrderTraversalTest() {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node3.children = new ArrayList<>(Arrays.asList(node5, node6));
        root.children = new ArrayList<>(Arrays.asList(node3, node2, node4));
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
        Assert.assertEquals(result.size(), 3);

    }

    /**
     * 多叉树的层次遍历
     *
     * @param root 根节点
     * @return 结果集
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            List<Integer> temp = new ArrayList();
            for (int i = 0; i < s; i++) {
                Node p = queue.poll();
                temp.add(p.val);
                int size = p.children.size();
                for (int j = 0; j < size; j++) {
                    Node n = p.children.get(j);
                    queue.add(n);
                }
            }
            result.add(temp);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
