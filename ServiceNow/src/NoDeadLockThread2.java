public class NoDeadLockThread2 implements Runnable{

    String resource1;
    String resource2;
    public NoDeadLockThread2(String resource1, String resource2){
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {

        synchronized (resource2) {
            // Thread-2 have resource2 but need resource1 also
            synchronized (resource1) {
                System.out.println("In block 2");
            }
        }

    }
}
