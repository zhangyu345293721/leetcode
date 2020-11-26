package leetcodejava.list;

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
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class PalindromeLinkedList234 {

    @Test
    public void palindromeLinkedList() {
        Integer[] arr1 = {4, 1, 1, 4};
        ListNode node = ListNode.createListNode(arr1);
        boolean palindrome = isPalindrome(node);
        System.out.println(palindrome);
    }

    /**
     * 判断链表是不是回文链表
     *
     * @param head 头结点
     * @return 布尔值
     */
    public boolean isPalindrome(ListNode head) {
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
            if (list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
