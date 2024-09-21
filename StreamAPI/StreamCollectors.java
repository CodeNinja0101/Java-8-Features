package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectors {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice");

//        // 1. Collecting elements into a List
//        List<String> namesList = names.stream().toList();
//        System.out.println("Collected to List: " + namesList);
//
//        // 2. Collecting elements into a Set
//        Set<String> namesSet = names.stream().collect(Collectors.toSet());
//        System.out.println("Collected to Set: " + namesSet);
//
//        // 3. Grouping elements by their length
//        Map<Integer, List<String>> groupedByLength = names.stream()
//                .collect(Collectors.groupingBy(String::length));
//        System.out.println("Grouped by Length: " + groupedByLength);
//
//        // 4. Partitioning elements based on a condition (names starting with 'A')
//        Map<Boolean, List<String>> partitioned = names.stream()
//                .collect(Collectors.partitioningBy(name -> name.startsWith("A")));
//        System.out.println("Partitioned by starting with 'A': " + partitioned);
//
//        // 5. Joining names with a delimiter
//        String joinedNames = names.stream()
//                .collect(Collectors.joining(", "));
//        System.out.println("Joined Names: " + joinedNames);
//
//        // 6. Summarizing lengths of names
//        IntSummaryStatistics stats = names.stream()
//                .collect(Collectors.summarizingInt(String::length));
//        System.out.println("Summary Statistics: " + stats);
//
//        // 7. Reducing to a single string by concatenation
//        Optional<String> concatenatedNames = names.stream()
//                .reduce((name1, name2) -> name1 + ", " + name2);
//        concatenatedNames.ifPresent(s -> System.out.println("Concatenated Names: " + s));
//


        List<String> words = Arrays.asList("Safari", "Chrome", "Firefox", "Edge", "Brave", "Opera", "Dock");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 3, 2, 1);
        // 1. Collecting elements into a List
        List<String> browser = words.stream().toList();
        System.out.println("Collected to List: " + browser);
        //or
        List<Integer> numbs = numbers.stream().toList();
        System.out.println("Collected to List: " + numbs);


        // 2. Collecting elements into a Set
        Set<String> brows = words.stream().collect(Collectors.toSet());
        System.out.println("Collected to List: " + brows);

        Set<Integer> nos = numbers.stream().collect(Collectors.toSet());
        System.out.println("Collected to List: " + nos);


        // 3. Grouping elements by their length
        Map<Integer, List<String>> wordsGroup = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouping elements by length: " + wordsGroup);


        // 4. Partitioning elements based on a condition (names starting with 'A')
        Map<Boolean, List<String>> partElements = words.stream()
                .collect(Collectors.partitioningBy(a -> a.startsWith("C")));
        System.out.println("Partitioning elements based on a condition: " + partElements);


        // 5. Joining names with a delimiter
        String joinedNames = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + joinedNames);
        //or
        List<String> languages = Arrays.asList("Java", "Python", "C", "Cpp");
        String joinedLanguages = String.join(", ", languages);
        System.out.println("Joined List: " + joinedLanguages);


        // 6. Summarizing lengths of names
        IntSummaryStatistics stats = names.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println("Summary Statistics: " + stats);
        //or
        IntSummaryStatistics statistics = languages.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println("Summary Stats: " + statistics);


        // 7. Reducing to a single string by concatenation
        Optional<String> singleString = names.stream()
                .reduce((a, b) -> a + ", " + b);
        singleString.ifPresent(n -> System.out.println("Concatenated Names: " + n));
        //or
        Optional<String> concatenatedNames = names.stream()
                .reduce((name1, name2) -> name1 + ", " + name2);
        concatenatedNames.ifPresent(s -> System.out.println("Concatenated Names: " + s));
    }
}
