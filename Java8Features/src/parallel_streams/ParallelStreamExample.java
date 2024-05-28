package parallel_streams;
/*
* Parallel streams in Java 8 provide a way to perform parallel processing of collections.
* They enable you to leverage the power of multi-core processors to execute stream operations concurrently,
* potentially improving the performance of your application when dealing with large datasets.


 * */
import java.util.Arrays;
public class ParallelStreamExample {
    public static void main(String args[]){
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Sequential stream example
        System.out.println("Sequential Stream:");

        int sumOfSquaresSequential = Arrays.stream(numbers).map(x-> x*x).sum();

        System.out.println("Sum of squares (sequential): " + sumOfSquaresSequential);

        //Parallel stream example

        System.out.println("\nParallel Stream:");

        int sumOfSquaresParallel = Arrays.stream(numbers).parallel().map(x-> x*x).sum();

        System.out.println("Sum of squares (parallel): " + sumOfSquaresParallel);
    }
}
