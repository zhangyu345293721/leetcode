package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * ==========================================================================================================
 * meeting room number
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddTwoNumbers2 {
    @Test
    public void addTwoNumbers() {
        ListNode node1 = ListNode.createListNode(Arrays.asList(9, 9, 9, 9, 9, 9, 9));
        ListNode node2 = ListNode.createListNode(Arrays.asList(9, 9, 9, 9));
        ListNode result = addTwoNumbers(node1, node2);
        System.out.println(result);
        Assert.assertEquals(result.val, 8);
    }

    
    /**
     * 两个链表相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表结果
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int total = num1 + num2 + carry;
            carry = total / 10;
            p.next = new ListNode(total % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            p = p.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }

    /**
     * 两个链表相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表结果
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        return this.addTwoNumberList(l1, l2, 0);
    }

    /**
     * 两个链表相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @param v  数字v
     * @return 返回合并后链表
     */
    private ListNode addTwoNumberList(ListNode l1, ListNode l2, int v) {
        if (l1 == null && l2 == null) {
            return v == 0 ? null : new ListNode(v);
        }
        if (l1 != null) {
            v += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            v += l2.val;
            l2 = l2.next;
        }
        return new ListNode(v % 10, addTwoNumberList(l1, l2, v / 10));
    }
}
