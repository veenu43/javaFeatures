package multithreading.synchronizedBlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadReentrantRunner {

    public static void main(String[] args){
        ExecutorService executorService= Executors.newFixedThreadPool(100);
        SynchronisedBlock block = new SynchronisedBlock();
        for(int i=0;i<100;i++){
            ReentrantLockThread thread = new ReentrantLockThread(block,"Name-"+i);
            executorService.submit(thread);
        }
        executorService.shutdown();
    }
}


