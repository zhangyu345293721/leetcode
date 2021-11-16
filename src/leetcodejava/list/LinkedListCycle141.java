package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No.141 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/linked-list-cycle
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LinkedListCycle141 {

    @Test
    public void linkedListCycleTest() {
        Integer[] arr = {3, 2, 0, -4};
        ListNode node = ListNode.createListNode(arr);
        boolean result = hasCycle(node);
        System.out.println(result);
        Assert.assertEquals(result, false);
    }

    /**
     * 判断链表中是否有环
     *
     * @param head 链表
     * @return 布尔值
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> nodesSeen = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (nodesSeen.contains(p)) {
                return true;
            } else {
                nodesSeen.add(p);
            }
            p = p.next;
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

    /**
     * 判断链表中是否有环
     *
     * @param head 链表
     * @return 布尔值
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
