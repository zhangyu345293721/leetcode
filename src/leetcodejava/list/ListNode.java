package leetcodejava.list;

import java.util.List;

/**
 * 定义一个listNode节点
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ListNode {
    /**
     * 节点存储的值
     */
    public int val;
    /**
     * 节点的指向
     */
    public ListNode next;

    /**
     * 构造方法
     *
     * @param x 节点传入的值
     */
    public ListNode(int x) {
        val = x;
    }


    /**
     * 将list转成ListNode
     *
     * @param list 链表
     * @return ListNode 生成listNode节点
     */
    public static ListNode createListNode(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        ListNode node = new ListNode(list.get(0));
        ListNode head = node;
        for (int i = 1; i < list.size(); i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        return head;
    }

    /**
     * 将数组转成ListNode
     *
     * @param arr 数组
     * @return ListNode 生成listNode节点
     */
    public static ListNode createListNode(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        ListNode node = new ListNode(arr[0]);
        ListNode head = node;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return head;
    }
}
