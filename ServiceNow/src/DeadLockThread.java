public class DeadLockThread implements Runnable{

    String resource1;
    String resource2;
    public DeadLockThread(String resource1, String resource2){
        this.resource1 = resource1;
        this.resource2 = resource2;
    }
    @Override
    public void run() {

        synchronized (resource1){
            System.out.println("Thread 1: locked resource 1");

            try { Thread.sleep(100);} catch (Exception e) {}

            synchronized (resource2){
                System.out.println("Thread 1: locked resource 2");
            }
        }

    }
}
