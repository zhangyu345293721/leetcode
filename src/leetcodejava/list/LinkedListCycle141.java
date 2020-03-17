package leetcodejava.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表中是否有环
 *
 * @author: zhangyu
 */
public class LinkedListCycle141 {

    /**
     * 判断链表中是否有环
     *
     * @param head 链表
     * @return 布尔值
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 判断链表中是否有环
     *
     * @param head 链表
     * @return 布尔值
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
