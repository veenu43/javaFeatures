package multithreading.prodConProb;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producer extends Thread {
    private BlockingQueue<String> queue;
    private String threadName;
    private int produceSize;
    private AtomicBoolean isAlive;
    private VolatileData volatileData;
    public static String poisonData = "Poison";

    public Producer(BlockingQueue<String> queue, String threadName, int produceSize, AtomicBoolean isAlive, VolatileData volatileData) {
        this.queue = queue;
        this.setName(threadName);
        this.produceSize = produceSize;
        this.isAlive = isAlive;
        this.volatileData = volatileData;
    }

    @Override
    public void run() {
        try {
            int count = 0;
            while (volatileData.isActive()) {
                produce(count++);
                TimeUnit.SECONDS.sleep(1);
            }
            produceData(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void produce(int count) {
        System.out.println("Produce Data: " + queue.add("Data_" + count));
    }

    private void produceData(int count) {
        System.out.println("Produce Data: " + queue.add(poisonData));
    }

}
