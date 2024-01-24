/*
Problem Description

        You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:

        LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] and (i>j). If multiple A[j]'s are present in multiple positions, the LeftSpecialValue is the maximum value of j.
        RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] and (j>i). If multiple A[j]'s are present in multiple positions, the RightSpecialValue is the minimum value of j.
        Write a program to find the maximum special product of any integer in the array.

        NOTE:  As the answer can be large, output your answer modulo 109 + 7.



        Problem Constraints
        1 <= N <= 105

        1 <= A[i] <= 109*/


import java.util.*;

public class LRProduct {

    static int MAX = 1000;
    public static void main(String args[]){
        int arr[] = new int[]{5, 4, 3, 4, 5};
        //int arr[] = new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1};

        int n = arr.length;

        System.out.print(LRProductDemo(arr, n));
    }

    static int LRProductDemo(int arr[], int n){

        // for each element storing
        // the index of just greater
        // element in left side
        int []left = nextGreaterInLeft(arr, n);

        // for each element storing
        // the index of just greater
        // element in right side
        int ans = -1;
       /* int []right = nextGreaterInRight(arr, n);

        for (int i = 1; i <= n; i++)
        {

            // finding the max
            // index product
            ans = Math.max(ans, left[i] *
                    right[i]);
        }*/

        return ans;
    }

    static int[]  nextGreaterInLeft(int []a, int n){

        int []left_index = new int[MAX];
        Stack<Integer> s = new Stack<Integer>();

        for (int i = n - 1; i >= 0; i--)
        {

            System.out.println("the index is:"+i);
            // checking if current
            // element is greater than top
            while (s.size() != 0 &&
                    a[i] > a[s.peek() - 1])
            {

                int r = s.peek();
                s.pop();
                System.out.println("value of r is:"+r);

                // on index of top store
                // the current element
                // index which is just
                // greater than top element
                left_index[r - 1] = i + 1;
            }

            // else push the current
            // element in stack
            s.push(i + 1);
        }
        return left_index;

    }

    static int[] nextGreaterInRight(int []a, int n){

        int []right_index = new int[MAX];
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {

            // checking if current element
            // is greater than top
            while (s.size() != 0 &&
                    a[i] > a[s.peek() - 1])
            {
                int r = s.peek();
                s.pop();

                // on index of top store
                // the current element index
                // which is just greater than
                // top element stored index
                // should be start with 1
                right_index[r - 1] = i + 1;
            }

            // else push the current
            // element in stack
            s.push(i + 1);
        }
        return right_index;
    }
}
