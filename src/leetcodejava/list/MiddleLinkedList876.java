package leetcodejava.list;

import org.junit.Test;

/**
 * 找出链表的中心节点
 *
 * @author: zhangyu
 */
public class MiddleLinkedList876 {

    @Test
    public void testMiddleLinkedList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode middle = middleNode(node1);
        System.out.println(middle);
    }

    /**
     * 找出中间结点
     *
     * @param head 头结点
     * @return 返回中间结点
     */
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        for (int i = 0; i < length / 2; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 找出中间结点
     *
     * @param head 头结点
     * @return 返回中间结点
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
