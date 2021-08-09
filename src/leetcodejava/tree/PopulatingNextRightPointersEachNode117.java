package leetcodejava.tree;


import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No. 117 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 * @date: 2020/9/28
 */
public class PopulatingNextRightPointersEachNode117 {

    @Test
    public void populatingNextRightPointersEachNodeTest() {
        Integer[] arr = {1, 2, 3, 4, 5, null, 7};
        Node node = Node.createTreeByArray(arr);
        Node result = connect2(node);
        System.out.println(result);
        Assert.assertEquals(result.val, 1);
    }

    /**
     * 深度优先遍历
     *
     * @param root 根节点
     * @return 节点
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.left != null && root.right == null) {
            root.left.next = getNext(root.next);
        }
        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    /**
     * 获取下一个节点
     *
     * @param root 根节点
     * @return 下个节点
     */
    public Node getNext(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        if (root.next != null) {
            return getNext(root.next);
        }
        return null;
    }

    /**
     * 广度优先遍历
     *
     * @param root 根节点
     * @return 节点
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        // 借助队列实现层次遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.remove();
                if (size > 0) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
