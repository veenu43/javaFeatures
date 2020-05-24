package multithreading.excepionHandling;

public class ThreadRunner {


    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("For thread:"+t.getName()+" Uncaught exception: " + e);
            }
        };


        Thread thread = new Thread() {
            @Override
            public void run() {
                this.setName("Test");
                throw new ArrayIndexOutOfBoundsException();
            }
        };

        thread.setUncaughtExceptionHandler(handler);
        thread.start();
    }
}
