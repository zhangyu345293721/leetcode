package leetcodejava.top100likedquestions;

import leetcodejava.list.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This is the solution of No.23 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MergeKSortedLists23 {

    @Test
    public void mergeKSortedListsTest() {
        ListNode l1 = ListNode.createListNode(Arrays.asList(1, 3, 4));
        ListNode l2 = ListNode.createListNode(Arrays.asList(1, 2, 5));
        ListNode l3 = ListNode.createListNode(Arrays.asList(1, 3, 7));
        ListNode[] lists = {l1, l2, l3};
        ListNode result = mergeKList(lists);
        System.out.println(result);
        Assert.assertEquals(result.val, 1);
    }

    /**
     * 多路合并链表
     *
     * @param lists 要合并的链表
     * @return 链表
     */
    public ListNode mergeKList(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }


    /**
     * 终止条件是l和r相等
     *
     * @param lists 链表
     * @param l     左边
     * @param r     右边
     * @return 合并后链表
     */
    private ListNode helper(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        // 防止值溢出
        int mid = (r - l) / 2 + l;
        ListNode l1 = helper(lists, l, mid);
        ListNode l2 = helper(lists, mid + 1, r);
        return merge(l1, l2);
    }

    /**
     * 通过指针合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并两个链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }
    /**
     * 通过指针合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并两个链表
     */
    private ListNode merge2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge2(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2(l1, l2.next);
            return l2;
        }
    }

    /**
     * 多路合并链表
     *
     * @param lists 要合并的链表
     * @return 链表
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode q1, ListNode q2) {
                        return q1.val - q2.val;
                    }
                }
        );
        int k = lists.length;
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            tail.next = cur;
            tail = tail.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
