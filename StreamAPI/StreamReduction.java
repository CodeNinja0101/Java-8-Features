package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. Basic Sum using reduce()
        // 2. Finding the Maximum using reduce()
        // 3. Finding the Minimum using reduce()
        // 4. Product of all elements using reduce()
        // 5. Concatenating Strings using reduce()
        // 6. Reduce without identity value (Optional result)
        // 7. Reduction with method reference
        // 8. Reducing with parallel stream


        Integer sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        Optional<Integer> max = numbers.stream()
                .reduce((a, b) -> a > b ? a : b);
        max.ifPresent(value -> System.out.println("Max: " + value));

        Optional<Integer> min = numbers.stream()
                .reduce((a, b) -> a < b ? a : b);
        min.ifPresent(value -> System.out.println("Min: " + value));

        Integer product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        List<String> words = Arrays.asList("Stream", "Reduction", "in", "Java");
        String concatenatedString = words.stream()
                .reduce("", (a, b) -> a + b + " ");
        System.out.println("Concatenated String: " + concatenatedString.trim());

        List<Integer> emptyList = List.of();
        Optional<Integer> emptySum = emptyList.stream()
                .reduce((a, b) -> a + b);
        System.out.println("Sum of empty list: " + emptySum.orElse(0));

        Integer sumMethodRef = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum (method reference): " + sumMethodRef);

        Integer parallelSum = numbers.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println("Parallel Sum: " + parallelSum);
    }
}

