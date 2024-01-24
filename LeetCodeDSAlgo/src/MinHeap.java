/*You are given K sorted integer arrays in a form of 2D integer matrix A of size K X N. */

class MinHeapNode {
    int element;
    int i;
    int j;
    public MinHeapNode(int element, int i, int j){
        this.element = element;
        this.i = i;
        this.j = j;
    }
};
public class MinHeap {
    public static void main(String args[]){
        int arr[][] = {{2,6,12,34},{1,9,20,1000},{23,34,90,2000}};
        mergeKSortedArrays(arr, arr.length);
    }

    static void mergeKSortedArrays(int[][] arr, int k) {
        MinHeapNode[] hArray = new MinHeapNode[k];
        int resultSize = 0;
        for(int i = 0; i < arr.length; i++) {
            MinHeapNode node = new MinHeapNode(arr[i][0],i,1);
            hArray[i] = node;
            resultSize += arr[i].length;
        }

        //System.out.println(hArray);


    }
}
