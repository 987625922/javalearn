package designpatterns.productionandconsumptionpattern;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产消费模式的生产者
 *
 */
public class Producer implements Runnable {

    private volatile boolean isRunning =true;
    private BlockingQueue<Data> queue; //内存缓冲区
    private static AtomicInteger count = new AtomicInteger(); //总数
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Data data = null;
        Random r = new Random();

        System.out.println("start 生产者 id="+Thread.currentThread().getId());
//        try{
//            while (isRunning){
//
//            }
//        }catch ()
    }
}
