package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No. 25 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReverseNodesKGroup25 {

    @Test
    public void reverseNodesKGroupTest() {
        List<Integer> list = new ArrayList<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        ListNode node = ListNode.createListNode(list);
        ListNode result = reverseKGroup(node, 2);
        System.out.println(result);
        Assert.assertEquals(result.val, 2);
    }

    /**
     * 反转k个数
     *
     * @param head 头结点
     * @param k    数量
     * @return 链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode p = head, p1 = head;
        dummy.next = head;
        // 记录链表的长度
        int len = 0;
        while (p1 != null) {
            len++;
            p1 = p1.next;
        }
        for (int i = 0; i < len / k; i++) {
            // 反转链表一部分
            for (int j = 0; j < k - 1; j++) {
                ListNode temp = p.next;
                p.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }
            // 改变指针方向
            prev = p;
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 反转k个数
     *
     * @param head 头结点
     * @param k    数量
     * @return 链表
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode p = head, p1 = head;
        // 记录链表的长度
        int len = 0;
        while (p1 != null) {
            len++;
            p1 = p1.next;
        }
        for (int i = 0; i < len / k; i++) {
            // 反转链表一部分
            for (int j = 0; j < k; j++) {
                ListNode temp = p.next;
                p.next = prev.next;
                prev.next = p;
                p = temp;
            }
            while (prev.next != null) {
                prev = prev.next;
            }
        }
        // 最后一部分零碎的要连接起来
        if (p != null) {
            prev.next = p;
        }
        return dummy.next;
    }
}
