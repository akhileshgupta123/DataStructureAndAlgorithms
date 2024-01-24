package Arrays;

public class GenerateSpiralMatrix1 {

    public static void main(String args[]){
        int arr[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //int arr[][] = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        GenerateSpiralMatrix1 obj = new GenerateSpiralMatrix1();
        int[][] result = obj.generateMatrix(arr);
/*
        for(int i =0; i< result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.println(result[i][j]);
            }
        }*/
    }

    private int[][] generateMatrix(int arr[][]){

        int result[][] = new int[arr.length][arr[0].length];
        int k = 1;
        int size = arr.length * arr[0].length;
        int top=0;
        int bottom = arr.length-1;
        int left = 0;
        int right = arr[0].length -1;

        while(k<=size){

            for(int i=left;i<=right;i++){
                result[top][i]=arr[top][i];
                System.out.print(arr[top][i]);
                k++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                result[i][right]=arr[i][right];
                System.out.print(arr[i][right]);
                k++;
            }
            right--;
            for(int i=right;i>=left; i--){
                result[bottom][i]=arr[bottom][i];
                System.out.print(arr[bottom][i]);
                k++;
            }
            bottom--;
            for(int i=bottom; i>=top; i--){
                result[i][left] = arr[i][left];
                System.out.print(arr[i][left]);
                k++;
            }
            left++;
        }

        return result;
    }
}
