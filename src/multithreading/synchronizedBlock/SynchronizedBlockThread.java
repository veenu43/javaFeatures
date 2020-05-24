package multithreading.synchronizedBlock;

public class SynchronizedBlockThread extends Thread{

    SynchronisedBlock operation;

    public SynchronizedBlockThread(SynchronisedBlock operation,String threadName) {
        this.operation = operation;
        this.setName(threadName);
    }

    @Override
    public void run() {
        operation.addSynchronizedBlock(1,this.getName());
    }
}
