package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        boolean palindrome = isPalindrome2(node);
        System.out.println(palindrome);
        Assert.assertEquals(palindrome, true);
    }

    /**
     * 判断链表是不是回文链表
     *
     * @param head 头结点
     * @return 布尔值
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return isPalindromeList(list);
    }

    /**
     * 判断list是不是连续节点
     *
     * @param list 链表
     * @return 布尔值
     */
    public boolean isPalindromeList(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    ListNode temp;

    /**
     * 判断链表是不是回文链表
     *
     * @param head 头结点
     * @return 布尔值
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        temp = head;
        return searchHelper(head);
    }

    /**
     * 深度优先遍历
     *
     * @param head 头结点
     * @return 布尔值
     */
    public boolean searchHelper(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = searchHelper(head.next) && temp.val == head.val;
        temp = temp.next;
        return res;
    }

    /**
     * 判断链表是不是回文链表(新建回文串)
     *
     * @param head 头结点
     * @return 布尔值
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode temp = (ListNode) head.clone();
        ListNode reverseNode = reverse(head);
        while (temp != null && reverseNode != null) {
            if (temp.val != reverseNode.val) {
                return false;
            }
            temp = temp.next;
            reverseNode = reverseNode.next;
        }
        return true;
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
}
