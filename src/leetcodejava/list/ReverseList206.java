package leetcodejava.list;

import org.junit.Test;

/**
 * 链表反转
 *
 * @author: zhangyu
 */
public class ReverseList206 {

    @Test
    public void testReverseList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode node = reverseList2(node1);
        System.out.println(node);
    }

    /**
     * 将链表进行反转
     *
     * @param head 头结点
     * @return 反转节点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 链表返回 非递归方式
     *
     * @param head 头节点
     * @return 节点
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //始终保持cur是pre的后驱节点，然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
