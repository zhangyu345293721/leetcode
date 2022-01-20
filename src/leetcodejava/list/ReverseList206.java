package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No. 206 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 反转一个单链表。
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseList206 {

    @Test
    public void reverseListTest() {
        List<Integer> list = new ArrayList<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        ListNode listNode = ListNode.createListNode(list);
        ListNode result = reverseList2(listNode);
        Assert.assertEquals(result.val, 5);
    }

    /**
     * 将链表进行反转
     *
     * @param head 头结点
     * @return 反转节点
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    /**
     * 链表返回 非递归方式
     *
     * @param head 头节点
     * @return 节点
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode h = dummy;
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = h.next;
            h.next = p;
            p = temp;
        }
        return dummy.next;
    }
}
