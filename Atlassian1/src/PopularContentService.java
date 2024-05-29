import java.util.*;
/*
* Implement a service that tracks popularity of a given set of IDs (that represent some piece of content).
* Write code to increase/decrease popularity of a piece of content and a method that tells you the most popular content at any time.
* */
public class PopularContentService {
    public static void main(String args[]){
        PopularContentService obj = new PopularContentService();
        List<TopPost>  result = obj.generateTopPost();


        PriorityQueue<TopPost> postList = new PriorityQueue<TopPost>(new Comparator<TopPost>(){
            public int compare(TopPost p, TopPost q){
                return q.views - p.views;
            }
        });



        List<TopPost> topPostList = obj.generateTopPost();

        for(TopPost post : topPostList){
            postList.add(post);
        }


        TopPost result1 = obj.findPopularContent(postList);

        System.out.println("current top post is:"+result1.id);


        postList.add(obj.createPost(7,"G",7, new Date()));

         result1 = obj.findPopularContent(postList);

        System.out.println("current top post is:"+result1.id);

        postList.add(obj.createPost(9,"K",70, new Date()));

        result1 = obj.findPopularContent(postList);

        System.out.println("current top post is:"+result1.id);

        obj.updatePopularityContent(9,-60,postList);

        result1 = obj.findPopularContent(postList);

        System.out.println("current top post is:"+result1.id);


        obj.updatePopularityContent(2,40,postList);

        result1 = obj.findPopularContent(postList);

        System.out.println("current top post is:"+result1.id);


    }


    public TopPost findPopularContent(PriorityQueue<TopPost> pq){
        return pq.peek();
    }

    public List<TopPost> generateTopPost(){
        List<TopPost> postList = new ArrayList<TopPost>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, -1);
        postList.add(createPost(1,"A",7, cal.getTime()));


        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());
        cal1.add(Calendar.HOUR, -24);

        postList.add(createPost(2,"B",12, cal1.getTime()));

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.add(Calendar.HOUR, -48);

        postList.add(createPost(3,"C",15, cal2.getTime()));

        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(new Date());
        cal3.add(Calendar.HOUR, -72);


        postList.add(createPost(4,"D",18, cal3.getTime()));


        Calendar cal4 = Calendar.getInstance();
        cal4.setTime(new Date());
        cal4.add(Calendar.HOUR, -96);

        postList.add(createPost(5,"E",20, cal4.getTime()));

        return postList;
    }

    public TopPost createPost(int id, String content, int views, Date currTime){
        return new TopPost(id,content, views, currTime);
    }

    public void updatePopularityContent(int id, int viewCount, PriorityQueue<TopPost> postList){
        List<TopPost> popItem = new ArrayList<TopPost>();

        while(!postList.isEmpty()){
            TopPost item = postList.poll();
            if(item.id == id){
                item.views = item.views + viewCount;
                popItem.add(item);
                break;
            }else{
                popItem.add(item);
            }
        }

        for(TopPost resultItem : popItem){
            postList.add(resultItem);
        }
    }

}
