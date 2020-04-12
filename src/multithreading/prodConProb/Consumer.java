package multithreading.prodConProb;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer extends Thread {
    private BlockingQueue<String> queue;
    private String threadName;
    private AtomicBoolean isAlive;

    public Consumer(BlockingQueue queue, String threadName, AtomicBoolean isAlive) {
        this.queue = queue;
        this.setName(threadName);
        this.isAlive = isAlive;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!consume()) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean consume() throws Exception {
        if (!queue.isEmpty()) {
            String data = queue.take();
            System.out.println("Consume Data: " + data);
            if (Producer.poisonData.equals(data)) {
                return false;
            }
        }
        return true;
    }

}
