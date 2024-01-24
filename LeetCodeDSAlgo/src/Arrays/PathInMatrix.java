package Arrays;

public class PathInMatrix {
    public static void main(String args[]){
        //int arr[][]=new int[][]{{1,0},{0,2}};
        //int arr[][]=new int[][]{{1,3},{3,2}};
        int arr[][]=new int[][]{
            {1, 3, 0, 3, 0},
            {3, 0, 0, 3, 3},
            {3, 0, 3, 2, 3},
            {3, 3, 3, 0, 0},
            {3, 0, 3, 3, 3}};
        PathInMatrix obj = new PathInMatrix();
        boolean result = obj.isPathExist(arr,0,0);
        System.out.println(result);
    }

    boolean isPathExist(int arr[][], int i, int j){

        if (i < 0 || j < 0 || (i > (arr.length-1)) || (j > (arr[0].length-1)) || arr[i][j] == 0)
            return false;

        if (arr[i][j] == 3)
            arr[i][j] = 0;

        if (arr[i][j] == 2)
            return true;

        return isPathExist(arr,i,j+1) || isPathExist(arr,i,j-1) || isPathExist(arr,i+1,j) || isPathExist(arr,i-1,j);

    }


}
