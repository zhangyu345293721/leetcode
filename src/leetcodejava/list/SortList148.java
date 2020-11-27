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
        ListNode listNode = sortList(node);
        Assert.assertEquals(listNode.val, 1);
    }

    /**
     * 对链表进行排序
     *
     * @param head 节点head
     * @return listNode节点
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    /**
     * 合并链表
     *
     * @param node node节点
     * @return 排序后节点
     */
    private ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode lastNode = getLastNode(node);
        ListNode l1 = mergeSort(node);
        ListNode l2 = mergeSort(lastNode);
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
        ListNode breakPoint = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            breakPoint = slow;
            slow = slow.next;
        }
        breakPoint.next = null;
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
}
