package Grind75;
//207. Course Schedule
//Time complexity:
//        O(N+E)
//Space complexity:
//        O(N+E)
import java.util.*;
public class CourseSchedule {
    public static void main(String args[]){
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        //int[][] prerequisites = new int[][]{{1,0},{0,1}};




        CourseSchedule obj = new CourseSchedule();
        boolean result = obj.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites){



        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();

        for(int i=0;i<prerequisites.length; i++){
            int p = prerequisites[i][1];
            int q = prerequisites[i][0];
            if(map.containsKey(p)){
                map.get(p).add(q);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(q);
                map.put(p, list);
            }

            indegree[q]++;
            System.out.println(indegree[q]);
        }
//each course in this queue has no dependency on other courses.
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){

            if(indegree[i] == 0) queue.offer(i);
        }

        int res = 0;
        System.out.println(queue.size());

        while(!queue.isEmpty()){

            int c = queue.poll();
            res++;

            if(map.containsKey(c)){
                List<Integer> dep = map.get(c);
                for(int cc : dep){
                    System.out.println("here:"+cc);
                    indegree[cc]--;
                    if(indegree[cc] == 0)
                        queue.offer(cc);
                }
            }
        }

        return res == numCourses;
    }
}
