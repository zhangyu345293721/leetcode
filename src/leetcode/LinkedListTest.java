package leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: LinkedListTest
 * @Description: TOTO
 * @date 2018/12/14 10:12
 **/


public class LinkedListTest {
    @Test
    public void fun() {
        LinkedList<String> stack=new LinkedList<>();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");
        System.out.println(stack.getLast());
        System.out.println(stack.getFirst());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
