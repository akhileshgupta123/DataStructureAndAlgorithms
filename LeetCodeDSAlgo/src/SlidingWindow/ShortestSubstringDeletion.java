package SlidingWindow;
import java.util.*;
/*
 Given a string s of length n. The task is to find the length of the shortest substring,
 which upon deletion makes the string to be consisting of distinct characters only.

Example: s = "abcbbk", removing substring "bb" will render "abck" which will make all characters in it unique. So we return 2.


 */
public class ShortestSubstringDeletion {
    public static void main(String args[]){
        String s = "abcbbk";
        int shortestLength = findShortestSubstringLength(s);
        System.out.println("Length of shortest substring after deletion: " + shortestLength);

    }
/*
    public static int shortestSubstringLength(String s){
        int n = s.length();
        int[] frequency = new int[26];

        int distinctChars = 0;
        int left = 0;
        int minLength = n;

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            if (frequency[currentChar - 'a'] == 0) {
                distinctChars++;
            }

            frequency[currentChar - 'a']++;


            while(distinctChars == right - left + 1 && left<n){
                minLength = Math.min(minLength, right - left + 1);
                System.out.println("left is:"+left);
                char leftChar = s.charAt(left);
                frequency[leftChar - 'a']--;
                if (frequency[leftChar - 'a'] == 0) {
                    distinctChars--;
                }
                left++;
            }
        }

        return minLength;
    }*/

/*
    public static int smallestUniqueSubstringLength(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int n = s.length();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Iterate through the string to find the smallest substring with frequency exactly 1
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        while (end < n && start<n) {
            char currentChar = s.charAt(end);
            // Decrease the frequency of currentChar in the map
            frequencyMap.put(currentChar, frequencyMap.get(currentChar) - 1);
            end++;

            // Shrink the window if a character's frequency becomes 0
            while (containsUniqueCharacters(frequencyMap) && start<n) {
                minLength = Math.min(minLength, end - start);
                char startChar = s.charAt(start);
                // Increase the frequency of startChar back
                frequencyMap.put(startChar, frequencyMap.get(startChar) + 1);
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private static boolean containsUniqueCharacters(HashMap<Character, Integer> map) {
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }*/



    public static int findShortestSubstringLength(String s) {
        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();
        int n = s.length();
        int left = 0;
        int minLen = n + 1; // Start with an impossibly high length

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            // Update the frequency of the current character
            if (!charFrequency.containsKey(currentChar)) {
                charFrequency.put(currentChar, 1);
            } else {
                charFrequency.put(currentChar, charFrequency.get(currentChar) + 1);
            }

            // If the current character's frequency is more than 1, move the left pointer
            System.out.println("outer current char is:"+currentChar);
            while (charFrequency.get(currentChar) > 1) {
                System.out.println("current char is:"+currentChar);
                char leftChar = s.charAt(left);
                System.out.println("left char is:"+leftChar);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                left++;
                System.out.println("left  is:"+left);
            }

            System.out.println("final size is:"+charFrequency.size());
            // Update the minimum length if the window is valid
            if (charFrequency.size() == n - (right - left + 1)) {
                System.out.println("inner left is:"+left);
                System.out.println("inner right is:"+right);
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        // If minLen was not updated, all characters are unique. Return 0.
        return minLen == n + 1 ? 0 : minLen;
    }

}
