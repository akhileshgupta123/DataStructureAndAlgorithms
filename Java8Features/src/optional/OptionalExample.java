package optional;
import java.util.*;

/*
* the Optional class to represent a container object that may or may not contain a non-null value.
* It helps to handle scenarios where a method may return a value or null, thus reducing the likelihood of encountering null pointer exceptions.
* */
public class OptionalExample {
    public static void main(String args[]){
        // Creating an Optional with a value
        Optional<String> optionalWithValue = Optional.of("Hello");
        System.out.println("Optional with value: " + optionalWithValue);

        // Creating an Optional with a null value
        Optional<String> optionalWithNull = Optional.ofNullable(null);
        System.out.println("Optional with null value: " + optionalWithNull);

        // Retrieving value from an Optional
        if (optionalWithValue.isPresent()) {
            String value = optionalWithValue.get();
            System.out.println("Value in optionalWithValue: " + value);
        } else {
            System.out.println("optionalWithValue is empty");
        }


        // Handling null value with orElse
        String valueOrElse = optionalWithNull.orElse("Default Value");
        System.out.println("Value from optionalWithNull (orElse): " + valueOrElse);

    }
}
