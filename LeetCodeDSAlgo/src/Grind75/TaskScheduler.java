package Grind75;
//621. Task Scheduler


// time complexity : o(n) time
// space complexity : o(26) space

import java.util.*;
public class TaskScheduler {
    public static void main(String args[]){
        //char[] tasks = new char[]{'A','A','A','B','B','B'};
        //int n = 2;


        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;

        TaskScheduler  obj = new TaskScheduler();
        int result = obj.leastInterval(tasks,n);

        System.out.println("resulyt is:"+result);
    }

    public int leastInterval(char[] tasks, int n){
        int freq[] = new int[26];
        for(char i: tasks){
            freq[i-'A']++;
        }

        Arrays.sort(freq);

        // Calculate the maximum frequency of any task
        int maxFreq = freq[25] - 1;

        /*System.out.println("maxfreq:"+maxFreq);
        System.out.println("maxfreq1:"+freq[25]);
        System.out.println("maxfreq2:"+freq[24]);
        System.out.println("maxfreq3:"+freq[23]);*/
        // Calculate the number of idle slots that will be required
        int idleSlots = maxFreq * n;


        // Iterate over the frequency array from the second highest frequency to the lowest frequency
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
            System.out.println("before:"+idleSlots);
            System.out.println("the before freq:"+freq[i]);
            System.out.println("the before maxfreq:"+maxFreq);
            idleSlots -= Math.min(maxFreq, freq[i]);
            System.out.println("after:"+idleSlots);
        }

        // If there are any idle slots left, add them to the total number of tasks
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;

    }
}
