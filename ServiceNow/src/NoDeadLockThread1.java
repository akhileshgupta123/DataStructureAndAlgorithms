public class NoDeadLockThread1 implements Runnable{

    String resource1;
    String resource2;
    public NoDeadLockThread1(String resource1, String resource2){
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {

        synchronized (resource2) {
            try {
                /* Adding delay so that both threads can start trying to lock resources */
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread-1 have resource1 but need resource2 also
            synchronized (resource1) {
                System.out.println("In block 1");
            }
        }
    }
}
