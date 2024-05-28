public class ThreadDeadLockExample {
    public static void main(String args[]){
        final String resource1 = "test1";
        final String resource2 = "test2";

        Thread t1 = new Thread(new DeadLockThread(resource1, resource2));
        Thread t2 = new Thread(new DeadLockThread1(resource1, resource2));
        t1.start();
        //Thread.sleep(5000);
        t2.start();
    }
}
