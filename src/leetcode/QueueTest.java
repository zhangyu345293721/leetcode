package leetcode;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: QueueTest
 * @Description: TOTO
 * @date 2018/12/14 14:04
 **/


public class QueueTest {
    @Test
    public void fun() {
        // 非阻塞队列
        /*Queue queue = new ConcurrentLinkedQueue();
        ConcurrentLinkedDeque deque = new ConcurrentLinkedDeque();
        deque.addFirst("aa");
        deque.addFirst("bb");
        deque.addFirst("cc");
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }*/

        // 阻塞队列
        BlockingQueue queue1 = new LinkedBlockingQueue();
        BlockingQueue queue2 = new ArrayBlockingQueue(2);
        BlockingQueue queue3 = new PriorityBlockingQueue();

    }

    @Test
    public void ArrayBlockingQueueTest() {
        // 阻塞队列  链表无界
        BlockingQueue queue1 = new LinkedBlockingQueue(); //堆
        BlockingQueue queue3 = new ArrayBlockingQueue(5);// 有界的阻塞队列 arrayList
        queue3.add(1);
        queue3.offer(2);
        try {
            queue3.put(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BlockingQueue queue4 = new LinkedBlockingDeque(); //无界双向队列  linkedList 无锁
        BlockingQueue queue5 = new DelayQueue(); //堆 无界限
        BlockingQueue queue6 = new SynchronousQueue(); // 无数据结构
        BlockingQueue queue7 = new LinkedTransferQueue();//堆 无界限
    }

    @Test
    public void fun2() throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(5);// 有界的阻塞队列 arrayList
        queue.offer(1);
        queue.offer(2);
        queue.add(3);
        queue.put(4);
        queue.add(4);
        queue.offer(888);
        System.out.println(queue);
    }
}
