package Hashing;

import java.util.*;

public class IntersactionArray {

    public static void main(String args[]){
        int arr1[]= new int[]{7, 1, 5, 2, 3, 6};
        int arr2[] = new int[]{3, 8, 6, 20, 7};

        IntersactionArray obj =new IntersactionArray();
        obj.printIntersection(arr1,arr2);
    }

    private void printIntersection(int arr1[], int arr2[]){
        Set<Integer> hs1 = new HashSet<Integer>();
       // Set<Integer> hs2 = new HashSet<Integer>();

        for(int i=0; i<arr1.length; i++){
            hs1.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            if(hs1.contains(arr2[i])){
                System.out.print(arr2[i] + " ");
            }
        }

    }
}
