package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamBasics {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 3, 7, 4, 9, 1, 6);

        // 1. Filtering: Keep only even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Even Numbers: " + evenNumbers);

        // 2. Mapping: Square each number
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("Squared Numbers: " + squaredNumbers);

        // 3. Sorting: Sort the numbers in ascending order
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        System.out.println("Sorted Numbers: " + sortedNumbers);

        // 4. Sorting in descending order
        List<Integer> sortedDescNumbers = numbers.stream()
                .sorted((a, b) -> b.compareTo(a))
                .toList();
        System.out.println("Sorted Numbers in Descending Order: " + sortedDescNumbers);

        // 5. Combining: Filter even numbers and square them
        List<Integer> evenSquaredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println("Even Squared Numbers: " + evenSquaredNumbers);
    }
}
