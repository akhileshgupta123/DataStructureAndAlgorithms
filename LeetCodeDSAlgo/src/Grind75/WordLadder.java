package Grind75;
//127. Word Ladder
import java.util.*;
//Time Complexity :- BigO(M^2 * N), where M is size of dequeued word & N is size of our word list

//        Space Complexity :- BigO(M * N) where M is no. of character that we had in our string & N is the size of our wordList.
public class WordLadder {
    public static void main(String args[]){

        String beginWord = "hit";

        String endWord = "cog";


        HashSet<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        WordLadder obj = new WordLadder();
        int result = obj.ladderLength(beginWord,endWord,wordList);

        System.out.println(result);

    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList){
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int len = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            len++;
            for(int i=0; i< size; i++){
                String s = queue.poll();
                if(s.equals(endWord)) return len;
                for(String n : getNext(s, wordList)){
                    queue.offer(n);
                }
            }

        }

        return 0;
    }

    private Set<String> getNext(String s, Set<String> wordList){
        char[] chars = s.toCharArray();
        Set<String> res = new HashSet<String>();
        for(int i=0; i< chars.length; i++){
            char c = chars[i];
            for(char x ='a'; x <= 'z'; x++){
                if(c == x) continue;
                chars[i] = x;
                String next = new String(chars);
                if(wordList.contains(next)){
                    System.out.println(next);
                    res.add(next);
                    wordList.remove(next);
                }

                chars[i] = c;
            }
        }
        return res;
    }
}
