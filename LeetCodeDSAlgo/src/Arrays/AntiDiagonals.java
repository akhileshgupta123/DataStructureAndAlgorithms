package Arrays;

import java.util.ArrayList;

public class AntiDiagonals {

    public static void main(String args[]){
        int arr[][] = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

        diagonal(arr);
    }

    static void diagonal(int arr[][]){
        int n = arr.length;
        int N = 2*n-1;

        System.out.println("the element is :"+n);
        System.out.println("total element is :"+N);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<N; i++){
            result.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                result.get(i+j).add(arr[i][j]);

                //System.out.println("inner element is :"+arr[i][j]);
            }
        }


        for(int i=0; i<result.size(); i++){
            System.out.println();

            for(int j=0;j<result.get(i).size(); j++){
                System.out.print(result.get(i).get(j)+" ");
            }
        }
    }
}
