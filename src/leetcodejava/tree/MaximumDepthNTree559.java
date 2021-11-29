package leetcodejava.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.559 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。 
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaximumDepthNTree559 {

    @Test
    public void balancedBinaryTreeTest() {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node3.children = new ArrayList<>(Arrays.asList(node5, node6));
        root.children = new ArrayList<>(Arrays.asList(node3, node2, node4));
        int result = maxDepth1(root);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * n岔树最大深度
     *
     * @param root 根节点
     * @return 深度
     */
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                for (int j = 0; j < n.children.size(); j++) {
                    if (n.children.get(j) != null) {
                        queue.add(n.children.get(j));
                    }
                }
            }
        }
        return depth;
    }


    /**
     * n岔树最大深度
     *
     * @param root 根节点
     * @return 深度
     */
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int childrenMaxDepth = 0;
        for (int i = 0; i < root.children.size(); ++i) {
            int depth = maxDepth2(root.children.get(i));
            if (depth > childrenMaxDepth) {
                childrenMaxDepth = depth;
            }
        }
        return childrenMaxDepth + 1;
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
