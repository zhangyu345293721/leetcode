package leetcodejava.list;

import leetcodejava.top100likedquestions.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出两个链表之间的交点
 *
 * @author: zhangyu
 */
public class IntersectionTwoLinkedLists160 {


    /**
     * 判断两个链表是否有交点
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 返回相交点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<Integer> list = new ArrayList<>();
        while (headA != null) {
            list.add(headA.val);
            headA = headA.next;
        }
        while (headB != null) {
            if (list.contains(headB.val)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
