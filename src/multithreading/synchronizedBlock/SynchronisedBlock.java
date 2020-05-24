package multithreading.synchronizedBlock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronisedBlock {

    static Lock lock = new Lock();
    public int addedNumber =0;
    ReentrantLock reentrantLock = new ReentrantLock(true);
    Semaphore semaphore = new Semaphore(5);

    public void addSynchronizedBlock(int number, String threadName){
        synchronized(lock){
            System.out.println("test synchronized.Lock is held by: "+threadName);
            addedNumber=addedNumber+number;
            System.out.println("added number: "+addedNumber);
        }
    }

    public void addReentrantLock(int number, String threadName){
        System.out.println("Is Locked: "+reentrantLock.isLocked());
        reentrantLock.lock();
        System.out.println("test reentrant lock.Lock is held by: "+threadName);
        try{
            Thread.sleep(100);
            addedNumber=addedNumber+number;
            System.out.println("added number: "+addedNumber);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }finally {
            reentrantLock.unlock();
            System.out.println("test reentrant lock.Lock is released by: "+threadName);
        }
     }

    public void addSemaphoreLock(int number, String threadName){
        System.out.println("Is Locked: "+semaphore.availablePermits());
        try{
            semaphore.acquire();
            System.out.println("Semaphore lock.Lock is released by: "+threadName);
            Thread.sleep(100);
            addedNumber=addedNumber+number;
            System.out.println("added number: "+addedNumber);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }finally {
            semaphore.release();
            System.out.println("Semaphore lock.Lock is released by: "+threadName);
        }
    }

     public synchronized void add(int number, String threadName){
         System.out.println("test synchronized method.Lock is held by: "+threadName);
         addedNumber=addedNumber+number;
         System.out.println("added number: "+addedNumber);
     }
}
