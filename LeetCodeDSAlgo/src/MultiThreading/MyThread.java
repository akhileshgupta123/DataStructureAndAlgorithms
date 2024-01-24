package MultiThreading;

public class MyThread extends Thread{
    volatile int i = 10;
    public static void main(String args[]){
        System.out.println("-----------Thread Information:-------- ");
        System.out.println("Thread Information: ");
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        System.out.println("Thread Id: "+Thread.currentThread().getId());
        System.out.println("Thread State: "+Thread.currentThread().getState());
        System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
        System.out.println("-------------------------------------");
        Thread t1 = new MyThread();
        t1.start();
    }

    public void run() {
        System.out.println("-----------Thread Information:-------- ");
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        System.out.println("Thread Id: "+Thread.currentThread().getId());
        System.out.println("Thread State: "+Thread.currentThread().getState());
        System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
        System.out.println("-------------------------------------");

        for(int i=0; i<=5; i++) {
            System.out.println(i);
        }
    }

    public synchronized void display(){

    }

    public void add(String item){
        synchronized(this){

        }
    }
}
