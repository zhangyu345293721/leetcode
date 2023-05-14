package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedList83 {

    @Test
    public void removeDuplicatesfromSortedListTest() {
        ListNode listNode = ListNode.createListNode(Arrays.asList(1, 2, 3, 3));
        ListNode result = deleteDuplicates(listNode);
        System.out.println(result);
        Assert.assertEquals(result.val, 1);
    }

    /**
     * 删除链表中重复的元素
     *
     * @param head 头结点
     * @return 链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        while (p != null) {
            if (pre.val == p.val) {
                pre.next = p.next;
            } else {
                pre = pre.next;
            }
            p = p.next;
        }
        return dummy.next;
    }
    
     /**
     * 删除链表中重复的元素
     *
     * @param head 头结点
     * @return 链表
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-101);
        // 头部插入法
        ListNode tail = dummy;
        ListNode p = head;
        // 遍历主链表
        while(p != null) {
            ListNode temp = p.next;
            if(p.val != tail.val) {
                p.next = null;
                tail.next = p;
                tail = tail.next;
            }
            p = temp;
        }
        return dummy.next;
    }
}
