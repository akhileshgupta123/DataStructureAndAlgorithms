import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistributionTicket {
    public static void main(String args[]){
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int k=5;
        DistributionTicket obj = new DistributionTicket();
        int result = obj.getLastPerson(array,k);
        System.out.println(result);

        Customer c1= new Customer(20,"Test");
        Customer c2= new Customer(20,"Test");

        HashSet<Customer> hs = new HashSet<Customer>();
        hs.add(c1);
        hs.add(c2);

        System.out.println(hs);
        System.out.println(hs.size());


        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        Stream<Integer> oddNumbers  = numbers.stream();

        System.out.println(oddNumbers.count());

        numbers  =numbers.stream().filter(o->o%2!=0).map(n->n*n).collect(Collectors.toList());
        System.out.println(numbers);

    }

    public int getLastPerson(int[] array, int k){
        int left = 0;
        int right = array.length-1;

        while(left<right){
            if(left+k<=right){
                left = left+k;
            }else{
                break;
            }

            if(right-k>=left){
                right = right-k;
            }else{
                break;
            }
        }

        /*if(left==right){
            return -1;
        }*/

        return array[right];
    }
}


class Customer{
    int id;
    String name;

    Customer(int id, String name){
        this.id = id;
        this.name = name;
    }
}
