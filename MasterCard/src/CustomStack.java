import java.util.*;
public class CustomStack {

   // ABC abc
    //string1.comraeTo(string)
    List<Integer> stack;
    //PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
    //PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>
    int maxElement = Integer.MIN_VALUE;
    int minElement = Integer.MAX_VALUE;
    CustomStack(){
        stack = new ArrayList<Integer>();
    }


    public int pop(){
        if(stack.isEmpty()){
            return -1;
        }else{
            int popitem = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return popitem;
        }
    }

    public int peek(){
        if(stack.isEmpty()){
            return -1;
        }else{
            int popitem = stack.get(stack.size()-1);
            return popitem;
        }
    }

    public void push(int data){
        stack.add(data);
        maxElement = Math.max(maxElement,data);
        minElement = Math.max(minElement,data);
        //minQueue.add()
    }

    public int getMax(){
        return maxElement;
    }

    public int getMin(){
        return minElement;
    }


}
