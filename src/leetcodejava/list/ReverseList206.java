package leetcodejava.list;

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
    public void testReverseList() {
        List<Integer> list = new ArrayList<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        ListNode listNode = ListNode.createListNode(list);
        ListNode node = reverseList(listNode);
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
            // 记录当前节点的下一个节点
            tmp = cur.next;
            // 始终保持cur是pre的后驱节点，然后将当前节点指向pre
            cur.next = pre;
            // pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
