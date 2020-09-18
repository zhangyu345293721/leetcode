package leetcodejava.list;

import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 0201 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RemoveDuplicateNodeLCCI0201 {

    @Test
    public void removeDuplicateNodeLCCITest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4));
        ListNode listNode = ListNode.createListNode(list);
        ListNode result = removeDuplicateNodes2(listNode);
        System.out.println(result);
    }

    /**
     * 删除所有的重复元素
     *
     * @param head 头指针
     * @return 返回值
     */
    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode dummyHead = head;
        while (head.next != null) {
            if (!set.contains(head.next.val)) {
                set.add(head.next.val);
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return dummyHead;
    }
}
