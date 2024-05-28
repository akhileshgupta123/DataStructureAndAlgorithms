//code to implement custom Lock api
public class CustomLockTest {
    public static void main(String args[]){
        CustomLock lock = new CustomLock();
        CustomLockThread t1 = new CustomLockThread(lock, "Thread 1");
        CustomLockThread t2 = new CustomLockThread(lock, "Thread 2");
        t1.start();
        t2.start();
    }
}

class CustomLockThread extends Thread{
    CustomLock lock;
    String name;
    CustomLockThread(CustomLock lock, String name){
        this.lock = lock;
        this.name = name;
    }
    public void run(){
        try{
            lock.lock();
            System.out.println("Thread "+this.name+ " acquired the lock");
            Thread.sleep(2000);

        }catch (InterruptedException ex){

        }finally {
            lock.unlock();
            System.out.println("Thread "+this.name+ " released the lock");
        }

    }
}
