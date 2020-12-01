package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 21 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-two-sorted-lists
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MergeTwoSortedLists21 {

    @Test
    public void mergeTwoSortedListsTest() {
        ListNode l1 = ListNode.createListNode(Arrays.asList(1, 2, 4));
        ListNode l2 = ListNode.createListNode(Arrays.asList(1, 3, 4, 5));
        ListNode node = mergeTwoLists(l1, l2);
        Assert.assertEquals(node.val, 1);

    }

    /**
     * 合并两个有序链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 == null) {
            node.next = l2;
        }
        if (l2 == null) {
            node.next = l1;
        }
        return listNode.next;
    }
}
