package leetcodejava.top100likedquestions;

import leetcodejava.list.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No.142 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LinkedListCycle142 {

    @Test
    public void linkedListCycleTest() {
        ListNode nodes = ListNode.createListNode(Arrays.asList(1, 2, 2, 3, 4));
        ListNode listNode = detectCycle(nodes);
        System.out.println(listNode);
        Assert.assertEquals(listNode, null);
    }

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
        // 先去判断有没有环
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
        // 有环然后找出环的位置
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * 找出链表中的环,利用hashSet
     *
     * @param head 头指针
     * @return 环对象
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode cur = node;
        Set<ListNode> set = new HashSet<>();
        while (cur.next != null) {
            if (set.contains(cur.next)) {
                return cur.next;
            }
            cur = cur.next;
            set.add(cur);
        }
        return null;
    }
}
