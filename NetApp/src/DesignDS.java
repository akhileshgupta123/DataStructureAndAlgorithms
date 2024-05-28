import java.util.*;
public class DesignDS {
    private int defaultValue;
    private Map<Integer,Integer> dict;

    public DesignDS()
    {
        defaultValue = 0;  //initialize default value
        dict = new HashMap<Integer, Integer>();
    }

    public void setAll(int val){
        defaultValue = val;
        dict = new HashMap<Integer, Integer>();
    }

    public int getVal(int index){
        if(dict.containsKey(index)){
            return dict.get(index);
        }else{
            return defaultValue;
        }
    }

    public void setValue(int index, int val){
        if(dict.containsKey(index)){
            dict.put(index, val);
        }else{
            dict.put(index, val);
        }
    }

}
