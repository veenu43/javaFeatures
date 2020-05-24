package multithreading.synchronizedBlock;

public class ReentrantLockThread extends Thread{

    SynchronisedBlock operation;

    public ReentrantLockThread(SynchronisedBlock operation, String threadName) {
        this.operation = operation;
        this.setName(threadName);
    }

    @Override
    public void run() {
        operation.addReentrantLock(1,this.getName());
    }
}
