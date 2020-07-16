package leetcodejava.array;

import leetcodejava.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangyu
 * @date: 2020/05/12 23:08
 */
public class TestNode {
    public static void main(String[]args){
        List<Integer> list=new ArrayList(Arrays.asList(1,2,3,4,5));
        ListNode listNode=convert2ListNode(list);
        System.out.println(listNode);
    }

    public static ListNode convert2ListNode(List<Integer> list){
        if(list==null||list.size()<1){
            return null;
        }
        ListNode node=new ListNode(list.get(0));
        ListNode head=node;
        for(int i=1;i<list.size();i++){
            node.next=new ListNode(list.get(i));
            node=node.next;
        }
        return head;

    }
}
