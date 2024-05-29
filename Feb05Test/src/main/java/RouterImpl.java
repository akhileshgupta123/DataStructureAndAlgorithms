import java.util.*;
public class RouterImpl implements RouterInterface{

    private Map<String,String> routerMap;

    public RouterImpl(){
        routerMap = new HashMap<String,String>();
    }

    @Override
    public void registerRoute(String key, String value) throws Exception {

        try{
            routerMap.put(key,value);
        }catch(Exception ex){
            System.out.println("Exception inside RouterImpl.registerRoute()"+ ex.getMessage());
            throw new Exception("Route Details could not be persist");
        }

    }

    @Override
    public String lookupRoute(String key) throws Exception {
        String result = null;

        if(routerMap.containsKey(key)){
            result = routerMap.get(key);
        }else{
            throw new Exception("Lookup Record Does Not Exist");
        }



        return result;
    }

    public Map<String, String> getRouterMap() {
        return routerMap;
    }

    public void setRouterMap(Map<String, String> routerMap) {
        this.routerMap = routerMap;
    }
}
