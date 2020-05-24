package multithreading.synchronizedBlock;

public class SemaphoreLockThread extends Thread{

    SynchronisedBlock operation;

    public SemaphoreLockThread(SynchronisedBlock operation, String threadName) {
        this.operation = operation;
        this.setName(threadName);
    }

    @Override
    public void run() {
        operation.addSemaphoreLock(1,this.getName());
    }
}
