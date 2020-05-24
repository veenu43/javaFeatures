package multithreading.synchronizedBlock;

public class SynchronizedMethodThread extends Thread{

    SynchronisedBlock operation;

    public SynchronizedMethodThread(SynchronisedBlock operation, String threadName) {
        this.operation = operation;
        this.setName(threadName);
    }

    @Override
    public void run() {
        operation.add(1,this.getName());
    }
}
