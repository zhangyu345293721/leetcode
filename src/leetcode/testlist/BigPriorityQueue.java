package leetcode.testlist;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: BigProprityQueue
 * @Description: TOTO
 * @date 2018/11/13 20:27
 **/


public class BigPriorityQueue {
    @Test
    public void fun() {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.poll());
    }
}
