package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.19 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RemoveNthNodeFromEndList19 {
    @Test
    public void decompressRunLengthEncodedTest() {
        Integer[] nums = {1, 2, 3, 4};
        ListNode node = ListNode.createListNode(nums);
        ListNode res = removeNthFromEnd(node, 2);
        Assert.assertEquals(res.val, 1);
    }

    /**
     * 移除倒数第n数字
     *
     * @param head 头结点
     * @param n    第n个数字
     * @return 结果链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = head;
        for (int i = 0; i < n; ++i) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 删除元素
        p1.next = p1.next.next;
        // 将元素置为空
        p1.next = null;
        return dummy.next;
    }
}
