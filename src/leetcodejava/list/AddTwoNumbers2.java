package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.2 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-two-numbers
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddTwoNumbers2 {
    @Test
    public void addTwoNumbers() {
        ListNode node1 = ListNode.createListNode(Arrays.asList(9, 9, 9, 9, 9, 9, 9));
        ListNode node2 = ListNode.createListNode(Arrays.asList(9, 9, 9, 9));
        ListNode result = addTwoNumbers(node1, node2);
        System.out.println(result);
        Assert.assertEquals(result.val, 8);
    }

    /**
     * 两个链表相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表结果
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode dummy = node;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int total = num1 + num2 + carry;
            carry = total / 10;
            node.next = new ListNode(total % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            node = node.next;
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return dummy.next;
    }

    /**
     * 两个链表相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表结果
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        return this.addTwoNumberList(l1, l2, 0);
    }
    /**
     * 两个链表相加
     *
     * @param l1 链表1
     * @param l2 链表2
     * @param v  数字v
     * @return 返回合并后链表
     */
    private ListNode addTwoNumberList(ListNode l1, ListNode l2, int v) {
        if (l1 == null && l2 == null) {
            return v == 0 ? null : new ListNode(v);
        }
        if (l1 != null) {
            v += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            v += l2.val;
            l2 = l2.next;
        }
        return new ListNode(v % 10, addTwoNumberList(l1, l2, v / 10));
    }
}
