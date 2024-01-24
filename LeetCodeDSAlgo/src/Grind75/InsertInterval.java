package Grind75;
import java.util.*;
//57. Insert Interval
public class InsertInterval {
    public static void main(String args[]){

        InsertInterval obj = new InsertInterval();

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));

        Interval newInterval = new Interval(4,8);
        List<Interval> result = obj.insert(intervals,newInterval);

        for(Interval it:result){
            System.out.println(it.start);
            System.out.println(it.end);
        }

    }

    public List<Interval>  insert(List<Interval> intervals, Interval newInterval){
        List<Interval> res = new ArrayList<>();
        if(intervals == null) return res;
        int i =0;
        for(; i< intervals.size(); i++){
            if(newInterval.end < intervals.get(i).start){
                res.add(newInterval);
                break;
            }else if(intervals.get(i).end < newInterval.start){
                res.add(intervals.get(i));
            }else{
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            }

        }

        System.out.println("i="+i);
        System.out.println("interval="+intervals.size());

        if(i == intervals.size()) res.add(newInterval);

        while(i < intervals.size()) res.add(intervals.get(i++));
        return res;
    }
}
