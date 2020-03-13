package leetcodejava.top100likedquestions;

import leetcodejava.list.ListNode;

/**
 * 找出链表中的环
 *
 * @author: zhangyu
 */
public class LinkedListCycle142 {

    /**
     * 找出链表中的环
     *
     * @param head 头指针
     * @return 环对象
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                return null;
            }
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
