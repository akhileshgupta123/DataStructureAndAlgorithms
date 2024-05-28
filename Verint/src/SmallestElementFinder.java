import java.util.*;
public class SmallestElementFinder {

    public static void main(String args[]){
        int[] intArray = new  int[]{4,6,7,1,8,9,7,2, 0, -2, -1, -5};
        SmallestElementFinder  smallestElementObj = new SmallestElementFinder();
        int indexValue = smallestElementObj.indexFinderOfSmallestElement(intArray);
        System.out.println("smallest index is :"+indexValue);
    }

    int indexFinderOfSmallestElement(int[] array){
        int index = 0;
        int smallestElement = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++){
            if(smallestElement>array[i]){
                smallestElement = array[i];
                index = i;
            }
        }
        return index;
    }

}
