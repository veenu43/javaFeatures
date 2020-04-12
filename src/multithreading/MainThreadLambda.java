package multithreading;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.*;

public class MainThreadLambda {

    public static void main(String[] args){
        Runnable task =()->{
            try
            {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }catch (Exception ex){
                ex.printStackTrace();
            }

        };
        Thread thread = new Thread(task);
        thread.start();


        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Future<Boolean> futureTask1 = executorService.submit(() ->{
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
            SECONDS.sleep(60);
            return true;
        });
        System.out.println("isDone " +  futureTask1.isDone());
        System.out.println("toString " +  futureTask1.toString());

    }
}
