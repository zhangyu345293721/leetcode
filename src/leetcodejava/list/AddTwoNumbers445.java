package leetcodejava.list;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 加上两个数字和
 *
 * @author: zhangyu
 */
public class AddTwoNumbers445 {

    @Test
    public void testAddTwoNumbers() {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node5.next = node6;
        node6.next = node7;

        ListNode listNode = addTwoNumbers(node1, node5);
        System.out.println(listNode);
    }

    /**
     * 加上两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 新链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Deque<Integer> stack1 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}
