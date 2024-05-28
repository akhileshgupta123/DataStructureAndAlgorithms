import java.util.concurrent.*;
public class ProducerConSumerClient {
    public static void main(String args){
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        //Consumer consumer = new Consumer(blockingQueue);
        //Producer producer new Producer(blockingQueue);
        Thread producerThread = new Producer(blockingQueue);
        Thread consumerThread = new Consumer(blockingQueue);
        producerThread.start();
        consumerThread.start();


    }
}
