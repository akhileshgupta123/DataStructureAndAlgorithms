public class DeadLockThread1 implements Runnable{
    String resource1;
    String resource2;
    public DeadLockThread1(String resource1, String resource2){
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {

        synchronized (resource2){
            System.out.println("Thread 2: locked resource 2");

            try { Thread.sleep(100);} catch (Exception e) {}

            synchronized (resource1){
                System.out.println("Thread 2: locked resource 1");
            }
        }

    }
}
