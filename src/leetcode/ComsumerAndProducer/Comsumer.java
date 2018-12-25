package leetcode.ComsumerAndProducer;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Comsumer
 * @Description: TOTO
 * @date 2018/12/14 8:48
 **/


public class Comsumer implements Runnable {
    private BlockingQueue shareQueue;
    public Comsumer(BlockingQueue shareQueue) {
        this.shareQueue = shareQueue;
    }
    @Override
    public void run() {
         while (true){
             try {
                 System.out.println(shareQueue.take());
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
