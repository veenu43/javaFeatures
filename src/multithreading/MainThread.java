package multithreading;

public class MainThread {

    public static void main(String[] args){
        PrintThread thread = new PrintThread();
        thread.setName("Print Thread");
        thread.setDaemon(false);
        thread.setPriority(4);
        thread.start();

        System.out.println("Daemon Thread active count: "+Thread.activeCount());
        System.out.println("Daemon Thread Name: "+Thread.currentThread().getName());
        System.out.println("Daemon Thread id: "+Thread.currentThread().getId());
        System.out.println("Daemon Thread Priority: "+Thread.currentThread().getPriority());
        System.out.println("Daemon Thread State: "+Thread.currentThread().getState().name());
        System.out.println("Daemon Thread isDaemon: "+Thread.currentThread().isDaemon());
        System.out.println("Daemon Thread isAlive: "+Thread.currentThread().isAlive());
        Thread.dumpStack();
    }


}
