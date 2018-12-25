package leetcode.ComsumerAndProducer;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Producer
 * @Description: TOTO
 * @date 2018/12/14 8:43
 **/


public class Producer implements Runnable{
    private BlockingQueue shareQuque;
    public Producer(BlockingQueue shareQuque){
        this.shareQuque=shareQuque;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                shareQuque.put("生产者"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
