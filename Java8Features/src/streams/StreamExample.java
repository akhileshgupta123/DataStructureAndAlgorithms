package streams;

import java.util.*;
import java.util.stream.Collectors;

/*
* Java 8 introduced the Stream API, which provides a powerful and flexible way to process collections of data.
* Streams in Java represent a sequence of elements that support various operations such as filtering, mapping, sorting, and reduction.
* */

public class StreamExample {
    public static void main(String args[]){
        // Create a list of strings
        List<String> words = new ArrayList<String>();
        words.add("apple");
        words.add("banana");
        words.add("cat");
        words.add("dog");
        words.add("elephant");

        // Example 1: Filter words starting with 'a' and collect them into a new list

        List<String> filteredWords = words.stream().filter(word -> word.startsWith("a")).collect(Collectors.toList());

        System.out.println("Filtered words starting with 'a': " + filteredWords);

        // Example 2: Convert all words to uppercase

        List<String>  joinedUppercaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("Filtered words  with upper case: " + joinedUppercaseWords);

        // Example 3: Count the number of words longer than 3 characters

        long count = words.stream()
                .filter(word -> word.length() > 3)
                .count();
        System.out.println("Number of words longer than 3 characters: " + count);

    }
}
