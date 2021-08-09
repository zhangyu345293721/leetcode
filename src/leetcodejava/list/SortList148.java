package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 148 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sort-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n.logn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * 示例 1：
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SortList148 {
    @Test
    public void sortListTest() {
        ListNode node = ListNode.createListNode(new Integer[]{1, 2, 3, 3, 4, 3});
        ListNode listNode = sortList2(node);
        Assert.assertEquals(listNode.val, 1);
    }

    /**
     * 对链表进行排序
     *
     * @param head 节点head
     * @return listNode节点
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = getLastNode(head);
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(lastNode);
        return merge(l1, l2);
    }

    /**
     * 获取下半部分节点
     *
     * @param node 节点
     * @return 后部分节点
     */
    private ListNode getLastNode(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        ListNode breakN = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            breakN = slow;
            slow = slow.next;
        }
        breakN.next = null;
        return slow;
    }

    /**
     * 合并两个链表
     *
     * @param l1 链表l1
     * @param l2 链表l2
     * @return 合并后链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /**
     * 通过指针合并两个链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并两个链表
     */
    private ListNode merge2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tail.next = new ListNode(l2.val);
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
     * 对链表进行排序
     *
     * @param head 节点head
     * @return listNode节点
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        quickSortHelper(head, null);
        return head;
    }

    /**
     * 快速排序
     *
     * @param start 头结点
     * @param end   尾节点
     */
    private void quickSortHelper(ListNode start, ListNode end) {
        if (start != end && start.next != end) {
            ListNode p = partition(start, end);
            quickSortHelper(start, p);
            quickSortHelper(p.next, end);
        }
    }

    /**
     * 划分
     *
     * @param begin 开始节点
     * @param end   结束节点
     * @return 结点
     */
    public ListNode partition(ListNode begin, ListNode end) {
        int baseVal = begin.val;
        ListNode base = begin;
        ListNode cur = begin.next;
        // 快速排序之单向划分方式
        while (cur != end) {
            if (cur.val < baseVal) {
                base = base.next;
                swap(base, cur);
            }
            cur = cur.next;
        }
        swap(base, begin);
        return base;
    }

    /**
     * 交换两个元素的值
     *
     * @param l1 链表l1
     * @param l2 链表l2
     */
    public void swap(ListNode l1, ListNode l2) {
        int temp = l1.val;
        l1.val = l2.val;
        l2.val = temp;
    }
}
