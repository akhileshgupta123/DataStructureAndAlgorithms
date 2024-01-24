import java.util.*;
public class ScannerExample1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        /*
        String name = sc.nextLine();
        char gender = sc.next().charAt(0);

        int age = sc.nextInt();
        long mobileNo = sc.nextLong();
        double cgpa = sc.nextDouble();
        String name1 = sc.next();

        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Age: "+age);
        System.out.println("Mobile Number: "+mobileNo);
        System.out.println("CGPA: "+cgpa);

        System.out.println("name1: "+name1);*/


        while (sc.hasNextInt())
        {
            // Read an int value
            int num = sc.nextInt();
            System.out.println("num is :"+num);
        }
    }
}
