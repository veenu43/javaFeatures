package multithreading.excepionHandling;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExcecutionServiceRunner {


    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                this.setName("Test");
                throw new ArrayIndexOutOfBoundsException();
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<?> future = executor.submit(thread);

        try {
            future.get();
        } catch (ExecutionException ex) {
            System.out.println("For thread:" + thread.getName() + " Uncaught exception: " + ex.getCause());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
