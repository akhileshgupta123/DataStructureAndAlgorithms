public class DeadlockSolved {
    public static void main(String args[]){

        final String resource1 = "test1";
        final String resource2 = "test2";
        NoDeadLockThread1 t1 = new NoDeadLockThread1(resource1,resource2);
        NoDeadLockThread2 t2 = new NoDeadLockThread2(resource1, resource2);
        new Thread(t1).start();
        new Thread(t2).start();

    }
}
