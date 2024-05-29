public class CacheClient {

    public static void main(String args[]) throws Exception{
        Cache cache =CacheImpl.getInstacnce(5);

        cache.set("1",11);
        cache.set("2",22);
        cache.set("3",33);
        cache.set("4",44);
        cache.set("5",55);
        //cache.set("6",66);
        Thread.sleep(4000);
        int result = cache.get("5");
        System.out.println("result of 5 :"+result);
        result = cache.get("4");
        System.out.println("result of 4 :"+result);
        result = cache.get("3");
        Thread.sleep(1000);
        System.out.println("result of 3 :"+result);
        result = cache.get("2");
        System.out.println("result of 2 :"+result);
        result = cache.get("1");
        System.out.println("result of 1 :"+result);


        cache.set("6",66);
        cache.set("7",77);

        //cache.set("8",88);

    }
}
