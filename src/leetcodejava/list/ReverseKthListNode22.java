package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.offer22 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/odd-even-linked-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseKthListNode22 {

    @Test
    public void reverseKthListNodeTest() {
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode result = getKthFromEnd(listNode, 3);
        System.out.println(result);
        Assert.assertEquals(result.val, 3);
    }

    /**
     * 获取倒数第k个元素链表
     *
     * @param head 头结点
     * @param k    数量k个元素
     * @return k个元素
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int step = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (step < k) {
            fast = fast.next;
            step++;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
