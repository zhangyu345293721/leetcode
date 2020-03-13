package leetcodejava.top100likedquestions;

import leetcodejava.list.ListNode;

/**
 * 合并k个有序数组
 *
 * @author: zhangyu
 */
public class MergeKSortedLists23 {

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
