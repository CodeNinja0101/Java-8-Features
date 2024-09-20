package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        // 1. Basic Sum using reduce()
//        // 2. Finding the Maximum using reduce()
//        // 3. Finding the Minimum using reduce()
//        // 4. Product of all elements using reduce()
//        // 5. Concatenating Strings using reduce()
//        // 6. Reduce without identity value (Optional result)
//        // 7. Reduction with method reference
//        // 8. Reducing with parallel stream
//
//
//        Integer sum = numbers.stream()
//                .reduce(0, (a, b) -> a + b);
//        System.out.println("Sum: " + sum);
//
//        Optional<Integer> max = numbers.stream()
//                .reduce((a, b) -> a > b ? a : b);
//        max.ifPresent(value -> System.out.println("Max: " + value));
//
//        Optional<Integer> min = numbers.stream()
//                .reduce((a, b) -> a < b ? a : b);
//        min.ifPresent(value -> System.out.println("Min: " + value));
//
//        Integer product = numbers.stream()
//                .reduce(1, (a, b) -> a * b);
//        System.out.println("Product: " + product);
//
//        List<String> words = Arrays.asList("Stream", "Reduction", "in", "Java");
//        String concatenatedString = words.stream()
//                .reduce("", (a, b) -> a + b + " ");
//        System.out.println("Concatenated String: " + concatenatedString.trim());
//
//        List<Integer> emptyList = List.of();
//        Optional<Integer> emptySum = emptyList.stream()
//                .reduce((a, b) -> a + b);
//        System.out.println("Sum of empty list: " + emptySum.orElse(0));
//
//        Integer sumMethodRef = numbers.stream()
//                .reduce(0, Integer::sum);
//        System.out.println("Sum (method reference): " + sumMethodRef);
//
//        Integer parallelSum = numbers.parallelStream()
//                .reduce(0, Integer::sum);
//        System.out.println("Parallel Sum: " + parallelSum);


        // 1. Basic Sum using reduce()
        Optional<Integer> sum1 = numbers.stream()
                .reduce(Integer::sum);
        System.out.println("Sum: " + sum1);
        //or
        Integer sum2 = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum2);


        // 2. Finding the Maximum using reduce()
        Optional<Integer> max = numbers.stream()
                .reduce((a, b) -> a > b ? a : b);
        max.ifPresent(value -> System.out.println("Max: " + value));
        //or
        Integer maxNum = numbers.stream()
                .reduce(1, (a, b) -> a > b ? a : b);
        System.out.println("Max: " + maxNum);


        // 3. Finding the Minimum using reduce()
        Optional<Integer> min = numbers.stream()
                .reduce((a, b) -> a < b ? a : b);
        min.ifPresent(val -> System.out.println("Min: " + val));
        //or
        Integer minNum = numbers.stream()
                .min(Integer::compareTo)
                .orElseThrow();
        System.out.println("Min: " + minNum);


        // 4. Product of all elements using reduce()
        Integer prod = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + prod);
        //or
        Optional<Integer> prodNum = numbers.stream()
                .reduce((a, b) -> a * b);
        prodNum.ifPresent(val -> System.out.println("Product: " + val));


        // 5. Concatenating Strings using reduce()
        List<String> words = Arrays.asList("Stream", "Reduction", "in", "Java");
        String concat = words.stream()
                .reduce("", (a, b) -> a + b + " ");
        System.out.println("Concatenated String: " + concat);
        //or
        String concatenatedString = words.stream()
                .reduce("", (a, b) -> a + b + " ");
        System.out.println("Concatenated String: " + concatenatedString.trim());


        // 6. Reduce without identity value (Optional result)
        List<Integer> emptyList = List.of();
        Optional<Integer> emptySum = emptyList.stream()
                .reduce(Integer::sum);
        System.out.println("Sum of empty list: " + emptySum.orElse(0));
        //or
        Optional<Integer> emptySum1 = emptyList.stream()
                .reduce((a, b) -> a + b);
        System.out.println("Sum of empty list: " + emptySum1.orElseGet(() -> 0));


        // 7. Reduction with method reference
        Integer sumMethodRef = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum (method reference): " + sumMethodRef);
        //or
        String conc = String.valueOf(words.stream()
                .reduce("", (String::concat)));
        System.out.println("String Concat" + conc);

        // 8. Reducing with parallel stream
        Integer parallelSum = numbers.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println("Parallel Sum: " + parallelSum);
        //or
        Integer multi = numbers.parallelStream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(multi);
    }
}

