package BinarySearch;

//1901. Find a Peak Element II

//O(nlogm) time | O(1) space

public class PeakElement {

    public static void main(String args[]){
        int arr[][] = new int[][]{{10,20,15},{21,30,14},{7,16,32}};
        PeakElement obj = new PeakElement();
        int[] result = obj.findPeakGrid(arr);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private int[] findPeakGrid(int mat[][]){
        int n = mat.length;
        int m = mat[0].length;
        int mid;
        int l=0;
        int r = m-1;

        while(l<=r){
            mid = (l+r)/2;
            int mx = mat[0][mid];
            int mxi=0;
            for(int i=1;i<n;i++){
                if(mx<mat[i][mid]){
                    mx=mat[i][mid];
                    mxi=i;
                }
            }

            int lv = mid>l?mat[mxi][mid-1]:-1;
            int rv = mid<r?mat[mxi][mid+1]:-1;
            if(mx>lv&&mx>rv){
                return new int[]{mxi, mid};
            }
            else if(mx>lv){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return new int[]{-1,-1};
    }
}
