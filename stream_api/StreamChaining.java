package stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamChaining {

    public static void main(String[] args) {
        List<String> places = Arrays.asList("Pune", "Mumbai", "Bengaluru", "Delhi", "Goa");

        // 1. Filter words with length greater than 5, convert to uppercase, and sort
        // 2. Chain multiple operations: filter, map, and collect
        // 3. Chaining with limit: Take only the first 3 elements after sorting
        // 4. Chain operations: filter, distinct, and count the results


        List<String> citiesUC = places.stream()
                .filter(cities -> cities.length() > 5)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println("Filtered, Uppercase and Sorted Words: " + citiesUC);

        List<String> multipleOperation = places.stream()
                .filter(a -> a.length() < 5)
                .map(String::toLowerCase)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Short Words in Reverse Order: " + multipleOperation);

        List<String> firstThreeLongPlaces = places.stream()
                .filter(word -> word.length() > 5)
                .map(String::toUpperCase)
                .sorted()
                .limit(3)
                .toList();
        System.out.println("First 3 Long Words: " + firstThreeLongPlaces);

        long uniquePlaceCount = places.stream()
                .filter(word -> word.contains("e"))
                .distinct()
                .count();
        System.out.println("Count of Unique Words Containing 'e': " + uniquePlaceCount);
    }
}

