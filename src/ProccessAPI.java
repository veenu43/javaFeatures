public class ProccessAPI {
    public static void main(String[] args)
    {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("Current Process API: "+ currentProcess.pid());
    }
}
