package leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Interval
 * @Description: TOTO
 * @date 2018/12/12 19:19
 **/


public class Interval {
    @Test
    public void fun(){
        LinkedList<Integer> linkedList=new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
    }
}
