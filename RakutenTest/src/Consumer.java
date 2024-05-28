import java.util.concurrent.ArrayBlockingQueue;

public class Consumer extends Thread{
    private ArrayBlockingQueue blockingDeque;
    Consumer(ArrayBlockingQueue blockingDeque){
        this.blockingDeque = blockingDeque;
    }

    public void run(){
        for(int i=0; i<20; i ++){
            Integer item = (Integer)this.blockingDeque.poll();
            System.out.println("Consumer item is"+item);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException ex){

            }
        }
    }
}
