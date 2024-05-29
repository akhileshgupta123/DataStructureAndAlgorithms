import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CacheImpl implements Cache{



    private Map<String, DataInfo> cacheMap;
    private int capacity;

    private static CacheImpl instance;

    private CacheImpl(int capacity){
        //cacheMap = new HashMap<String,DataInfo>();
        cacheMap = new ConcurrentHashMap<String,DataInfo>();
        this.capacity = capacity;
    }


    public static CacheImpl getInstacnce(int capacity){

        if(instance==null){
            synchronized (CacheImpl.class){
                if(instance == null){
                    instance = new CacheImpl(capacity);
                }
            }
        }

        return instance;
    }




    @Override
    public synchronized void  set(String key, int data) throws Exception {

        if(cacheMap.size()<capacity){ // 55
            if(cacheMap.containsKey(key)){ //36
                DataInfo result = cacheMap.get(key); //37
                result.creationTime = new Date();
                cacheMap.put(key,result); //39
            }else{
                DataInfo result = new DataInfo(data,new Date());
                cacheMap.put(key,result); //42
            }
        }else{
            for(Map.Entry<String,DataInfo> entry: cacheMap.entrySet()){
                if((new Date()).getTime()-entry.getValue().creationTime.getTime()>=5000){
                    System.out.println("jherr");
                    cacheMap.remove(entry.getKey());

                }
            }

            if(cacheMap.size()<capacity){
                DataInfo result = new DataInfo(data,new Date());
                cacheMap.put(key,result);

            }else{
                throw new Exception("Cache is Full");
            }
        }


    }

    @Override
    public synchronized int get(String key) {
        int keyValue = -1;
        DataInfo result = cacheMap.get(key);

        if(result!=null && ((new Date()).getTime()-result.creationTime.getTime()<5000)){

            result.creationTime = new Date();
            cacheMap.put(key,result);
            return result.data;
        }


        return keyValue;
    }

    @Override
    public synchronized void remove(String key) {

        if(cacheMap.containsKey(key)){
            cacheMap.remove(key);
        }

    }
}
