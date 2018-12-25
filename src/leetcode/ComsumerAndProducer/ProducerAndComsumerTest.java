package leetcode.ComsumerAndProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ProducerAndComsumerTest
 * @Description: TOTO
 * @date 2018/12/14 8:42
 **/


public class ProducerAndComsumerTest {
    public static void main(String[] args) {
        BlockingQueue shareQueue = new LinkedBlockingQueue();
        Producer p = new Producer(shareQueue);
        Comsumer c = new Comsumer(shareQueue);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
