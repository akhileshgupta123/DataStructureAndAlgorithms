package Arrays;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
//56. Merge Intervals
class Interval{
    int start,end;
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}
public class MergeOverlappingIntervals {

    public static void main(String args[]){

        Interval arr[]= new Interval[4];

        arr[0]=new Interval(1,3);
        arr[1]=new Interval(2,6);
        arr[2]=new Interval(8,10);
        arr[3]=new Interval(15,18);


        //[1,3],[2,6],[8,10],[15,18]

        MergeOverlappingIntervals obj = new MergeOverlappingIntervals();
        List<Interval> res =  obj.mergeIntervals(arr);
        for(Interval item : res){
            System.out.println(item.start);
            System.out.println(item.end);
        }

    }

    private List<Interval> mergeIntervals(Interval arr[]){

        for(Interval itr:arr){
            System.out.println("before sort:"+itr.start);
        }

        Arrays.sort(arr, new Comparator<Interval> () {
            public int compare(Interval i1,Interval i2)
            {
                return i1.start - i2.start;
            }

        });

        for(Interval itr:arr){
            System.out.println("after sort:"+itr.start);
        }


        int n = arr.length;
        List<Interval> res = new ArrayList();
        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(vis[i]){
                continue;
            }

            System.out.println("here");
            vis[i] = true;

            int minS = arr[i].start;
            int maxE = arr[i].end;

            //while(true){
                for (int j = 0; j < n; j++) {

                    if (!vis[j] && isOverlap(minS, maxE, arr[j])) {
                        vis[j] = true;
                        minS = Math.min(minS, arr[j].start);
                        maxE = Math.max(maxE, arr[j].end);
                        //c++;
                    }
                }
           // }

            res.add(new Interval(minS, maxE));
        }


        return res;

    }


    public  boolean isOverlap(int minS, int maxE, Interval i) {
        if (minS > i.end || maxE < i.start) {
            return false;
        }

        /*if (maxE < i.start) {
            return false;
        }*/
        return true;
    }
}
