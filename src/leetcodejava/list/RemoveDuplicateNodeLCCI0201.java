package leetcodejava.list;
import java.util.Set;
import java.util.HashSet;
/**
 * This is the solution of No. 0201 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RemoveDuplicateNodeLCCI0201 {

    public void removeDuplicateNodeLCCITest(){

    }
    /**
     * 删除所有的重复元素
     * @param head 头指针
     * @return 返回值
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (!set.contains(pre.next.val)) {
                set.add(pre.next.val);
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return dummyHead.next;
    }
}
