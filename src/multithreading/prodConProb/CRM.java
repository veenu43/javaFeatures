package multithreading.prodConProb;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.concurrent.TimeUnit.*;

public class CRM {

    public static void main(String[] args){
        int produceSize =10;
        VolatileData volatileData = new VolatileData();
        AtomicBoolean isAlive = new AtomicBoolean(true);
        BlockingQueue<String> queue= new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue,"Producer",produceSize,isAlive,volatileData);
        Consumer consumer = new Consumer(queue,"Consumer",isAlive);
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future consumerFuture = executorService.submit(consumer);
        Future producerFuture = executorService.submit(producer);
        try {
            SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producer Thread alive: "+producerFuture.isDone());
        System.out.println("Consumer Thread alive: "+consumerFuture.isDone());
        isAlive.set(false);
        volatileData.disableActive();
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producer Thread alive after stop: "+producerFuture.isDone());
        System.out.println("Consumer Thread alive after stop: "+consumerFuture.isDone());
        executorService.shutdown();
    }
}
