import java.util.*;
public class TopPost {
    int id;
    String content;
    int views;
    Date postTime;
    public TopPost(int id, String content, int views, Date currTime){
        this.id = id;
        this.content = content;
        this.views = views;
        this.postTime = currTime;
    }
}
