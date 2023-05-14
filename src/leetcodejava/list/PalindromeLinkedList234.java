package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.234 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/palindrome-linked-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PalindromeLinkedList234 {

    @Test
    public void palindromeLinkedListTest() {
        Integer[] arr1 = {1, 2, 1};
        ListNode node = ListNode.createListNode(arr1);
        boolean palindrome = isPalindrome1(node);
        System.out.println(palindrome);
        Assert.assertEquals(palindrome, true);
    }

    /**
     * 反转节点
     *
     * @param head 头结点
     * @return 链表
     */
    private ListNode reverse(ListNode head) {
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 判断链表是不是回文链表(新建回文串)
     *
     * @param head 头结点
     * @return 布尔值
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middleNode = getMiddleNode(head);
        ListNode reverseList = getReverseList(middleNode);
        while(reverseList != null) {
            if(head.val != reverseList.val) {
                return false;
            }
            reverseList = reverseList.next;
            head = head.next;
        }
        return true;
    }

   /**
    *找到中间节点
    */
    public ListNode getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    /**
     * 反转链表
     */
    public ListNode getReverseList(ListNode middleNode){
        if(middleNode == null || middleNode.next == null) {
            return middleNode;
        }
        ListNode pre = getReverseList(middleNode.next);
        middleNode.next.next = middleNode;
        middleNode.next = null;
        return pre;
    }

    /**
     * 反转链表
     *
     * @param head 头节点
     * @return 链表
     */
    private ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 判斷是否是回文链表
     *
     * @param head 头结点
     * @return 布尔值
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        long s1 = 0, s2 = 0;
        long t = 1;
        ListNode p = head;
        while (p != null) {
            s1 = 10 * s1 + p.val;
            s2 = s2 + t * p.val;
            t *= 10;
            p = p.next;
        }
        return s1 == s2;
    }
}
