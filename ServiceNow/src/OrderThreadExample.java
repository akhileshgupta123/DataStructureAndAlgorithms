//code to Order the threads
public class OrderThreadExample {
    public static void main(String args[]){
        OrderThread t1 = new OrderThread(null);
        OrderThread t2 = new OrderThread(t1);
        OrderThread t3 = new OrderThread(t2);
        t1.start();
        t2.start();
        t3.start();

    }
}

class OrderThread extends Thread{
    private Thread previousThread;
    public OrderThread(Thread previousThread){
        this.previousThread = previousThread;
    }
    public void run(){
        try{

            if (previousThread != null) {
                previousThread.join();
            }
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " is running");
        }catch(InterruptedException ex){
            ex.printStackTrace();;
        }

    }
}
