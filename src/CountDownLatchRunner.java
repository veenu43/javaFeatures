import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountDownLatchRunner {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        IntStream.range(0, 100).forEach(i-> executor.submit(
                new Runnable() {
                    private CountDownLatch latch;
                    private String threadName;
                    @Override
                    public void run() {
                        System.out.println("Count Down starting for Thread: "+threadName);
                        latch.countDown();
                        System.out.println("Count Down for Thread: "+threadName);
                    }

                    public Runnable setLatch(CountDownLatch latch,String threadName){
                        this.latch = latch;
                        this.threadName = threadName;
                        return this;
                    }
                }.setLatch(latch,"Worker-"+i)
        ));
        latch.await();
    }
}
