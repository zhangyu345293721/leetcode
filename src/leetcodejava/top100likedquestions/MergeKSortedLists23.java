package leetcodejava.top100likedquestions;

import leetcodejava.list.ListNode;
import org.junit.Test;

/**
 * This is the solution of No.23 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MergeKSortedLists23 {

    @Test
    public void mergeKSortedListsTest(){

    }
    /**
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
        int mid = (l + r) / 2;
        return merge(helper(lists, l, mid), helper(lists, mid + 1, r));
    }

    /**
     * 通过指针合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并两个链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
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
}
