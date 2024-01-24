package Arrays;
//1504. Count Submatrices With All Ones
public class CountSubMatrix {
    public static void main(String args[]){
        CountSubMatrix obj = new CountSubMatrix();
        int mat[][] = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
        int result = obj.countMatrix(mat);

        System.out.println("the result is :"+result);
    }

    private int countMatrix(int mat[][]){
        int m = mat.length;
        int n = mat[0].length;
        int arr[][]= new int[m][n];

        for(int i=0; i<m; i++){
            arr[i][0]=mat[i][0];

            for(int j=1;j<n;j++){
                if(mat[i][j]==1){
                    arr[i][j]=arr[i][j-1]+1;
                }
            }
        }


        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                ans+=arr[i][j];
                int min=arr[i][j];
                System.out.println("outside min is:"+min);
                for(int k=i+1;k<m;k++){
                    min=Math.min(min,arr[k][j]) ;
                    System.out.println("inner min is:"+min);
                    System.out.println("inner arr is:"+arr[k][j]);
                    System.out.println("row and col arr is:"+k + "   "+j);
                    ans+=min;
                }
            }
        }

        return ans;
    }
}
