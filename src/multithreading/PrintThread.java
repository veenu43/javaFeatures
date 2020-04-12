package multithreading;

public class PrintThread extends Thread {


    @Override
    public void run() {
        System.out.println("Thread active count: "+Thread.activeCount());
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        System.out.println("Thread id: "+Thread.currentThread().getId());
        System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
        System.out.println("Thread State: "+Thread.currentThread().getState().name());
        System.out.println("Thread isDaemon: "+Thread.currentThread().isDaemon());
        System.out.println("Thread isAlive: "+Thread.currentThread().isAlive());
    }
}
