package MultiThreading;

public class ReEntrantRunnable implements Runnable{
    ReentrantLockMethodsCounter lockMethodsCounter;
    String name;
    public ReEntrantRunnable(ReentrantLockMethodsCounter lockMethodsCounter, String name){
        this.lockMethodsCounter = lockMethodsCounter;
        this.name = name;

    }

    public void run(){
        System.out.println("IncrementCount ("+name+" Thread) : " +
                lockMethodsCounter.incrementAndGet() + "\n");
    }
}
