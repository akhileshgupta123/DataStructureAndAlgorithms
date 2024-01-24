package Arrays;
//11. Container With Most Water
public class ContainerWater {

    public static void main(String args[]){
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};
        int c[] = {1,8,6,2,5,4,8,3,7};

        int len1 = a.length;
        int len2 = b.length;
        int len3 = c.length;

        ContainerWater obj = new ContainerWater();
        int area = obj.maxArea(a,len1);

        System.out.println("the area of container is :"+area);


        area = obj.maxArea(b,len2);

        System.out.println("the area of container is :"+area);

        area = obj.maxArea(c,len3);

        System.out.println("the area of container is :"+area);
    }

    private int maxArea(int arr[], int len){
        int l = 0;
        int r = len-1;
        int area = 0;

        while(l<r){

            area = Math.max(area, Math.min(arr[l],arr[r]) * (r-l));
            if(arr[l]<arr[r]){
                l++;
            }else{
                r--;
            }

        }
        return area;
    }
}
