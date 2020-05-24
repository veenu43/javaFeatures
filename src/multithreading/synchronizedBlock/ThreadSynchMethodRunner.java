package multithreading.synchronizedBlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSynchMethodRunner {

    public static void main(String[] args){
        ExecutorService executorService= Executors.newFixedThreadPool(100);
        SynchronisedBlock block = new SynchronisedBlock();
        for(int i=0;i<100;i++){
            SynchronizedMethodThread thread = new SynchronizedMethodThread(block,"Name-"+i);
            executorService.submit(thread);
        }
        executorService.shutdown();
    }
}


