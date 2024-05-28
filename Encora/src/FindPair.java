import java.util.*;
public class FindPair {
    public static void main(String args[]){

        //int[] arr = new int[]{1, 5, 7, -1};
        int[] arr = new int[]{1, 5, 7,  -1,5,1};



                int K = 6;




        FindPair obj = new FindPair();
        int result = obj.findCount(arr,K);

        System.out.println(result);


        int a[] = { 1, 3, 4, 2, 7, 5, 8, 6 };
        int n = a.length;

        Arrays.sort(a);

        if (n % 2 != 0){
            System.out.println(a[n/2]);
        }else{
            double result1 = (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
            System.out.println("final result is:"+result1);
        }



    }

    public int findCount(int[] arr, int K){
        int count = 0;
        //HashMap<Integer,Integer> mapItem = new HashMap<Integer,Integer>();

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;

        while(left<right){
            if(arr[left]+arr[right]==K){
                count++;

                if(arr[right]!=arr[right-1] && arr[left]!=arr[left+1]){
                    right--;
                    left++;
                }else  if(left<right && (arr[left]==arr[left+1] || arr[right]==arr[right-1])){
                    count--;
                    int left_temp = 1;
                    int right_temp = 1;
                    while(left<right && arr[left]==arr[left+1] && arr[right]==arr[right-1]){
                        left_temp++;
                        right_temp++;
                        left++;
                        right--;
                    }
                    while(left<right && arr[left]==arr[left+1]){
                        left_temp++;
                        left++;
                    }

                    while(left<right && arr[right]==arr[right-1]){
                        right_temp++;
                        right--;
                    }

                    left++;
                    right--;
                    System.out.println("left"+left_temp);
                    System.out.println("right"+right_temp);
                    count = count + (left_temp*right_temp);

                    System.out.println("final left:"+arr[left]);
                    System.out.println("final right:"+arr[right]);
                }
                else if(arr[right]!=arr[right-1]){
                    right--;
                }else if(arr[left] != arr[left+1]){
                    left++;
                }/*else{


                }*/
            }else if(arr[left]+arr[right]>K){
                right--;
            }else if(arr[left]+arr[right]<K){
                left++;
            }
        }



       /* for(int item: arr){
            //int element = K-item;

            if(mapItem.containsKey(item)){
                count++;
                mapItem.put(item,mapItem.get(item)+1);
                //count = count + mapItem.get(item);
                //count++;

            }else{
                mapItem.put( K-item,0);
            }
        }*/

        return count;
    }
}
