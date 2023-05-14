package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.203 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/remove-linked-list-elements
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RemoveLinkedListElements203 {

    @Test
    public void removeLinkedListElementsTest() {
        ListNode node = ListNode.createListNode(Arrays.asList(1, 2, 2, 3, 4, 2));
        ListNode result = removeElements(node, 2);
        System.out.println(result);
        Assert.assertEquals(result.val, 1);
    }

    /**
     * 移除相同的元素
     *
     * @param head 头结点
     * @param val  值
     * @return 结果
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 移除相同的元素
     *
     * @param head 头结点
     * @param val  值
     * @return 结果
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            } else {
                pre = pre.next;
            }
            p = p.next;
        }
        return dummy.next;
    }
    
    /**
     * 移除相同的元素
     *
     * @param head 头结点
     * @param val  值
     * @return 结果
     */
    public ListNode removeElements3(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(head != null) {
            ListNode temp = head.next;
            if(head.val != val) {
                head.next = null;
                tail.next = head;
                tail = tail.next;
            }
            head = temp;
        }
        return dummy.next;
    }
}
