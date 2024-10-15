package stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 101, 102, 103, 80, 90, 100);

//        // Sequential Stream: Sum of squares
//        long startTime = System.currentTimeMillis();
//        int sumOfSquares = numbers.stream()
//                .map(n -> n * n)
//                .reduce(0, Integer::sum);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Sequential Sum of Squares: " + sumOfSquares + " Time: " + (endTime - startTime) + "ms");
//
//        // Parallel Stream: Sum of squares
//        startTime = System.currentTimeMillis();
//        int parallelSumOfSquares = numbers.parallelStream()
//                .map(n -> n * n)
//                .reduce(0, Integer::sum);
//        endTime = System.currentTimeMillis();
//        System.out.println("Parallel Sum of Squares: " + parallelSumOfSquares + " Time: " + (endTime - startTime) + "ms");
//
//        // Filtering even numbers using parallel stream
//        List<Integer> evenNumbers = numbers.parallelStream()
//                .filter(n -> n % 2 == 0)
//                .toList(); // In Java 16+, .toList() can be used instead
//        System.out.println("Even Numbers (Parallel): " + evenNumbers);
//
//        // Sorting in parallel
//        List<Integer> sortedNumbers = numbers.parallelStream()
//                .sorted()
//                .toList();
//        System.out.println("Sorted Numbers (Parallel): " + sortedNumbers);
//
//        // Demonstrating that the order is not guaranteed in parallel processing
//        System.out.println("Processing order demonstration:");
//        numbers.parallelStream().forEach(n -> System.out.print(n + " "));
//        System.out.println();
//
//        // Using parallel streams for heavy computation tasks
//        List<Integer> largeNumbers = IntStream.rangeClosed(1, 1_000_000)
//                .boxed()
//                .toList();
//
//        startTime = System.currentTimeMillis();
//        int largeSum = largeNumbers.parallelStream()
//                .reduce(0, Integer::sum);
//        endTime = System.currentTimeMillis();
//        System.out.println("Parallel Sum of Large Numbers: " + largeSum + " Time: " + (endTime - startTime) + "ms");


        // 1. Sequential Stream: Sum of squares
        long startTime1 = System.currentTimeMillis();
        int sum = numbers.stream()
                .map(a -> a * a)
                .reduce(0, Integer::sum);
        long endTime1 = System.currentTimeMillis();
        System.out.println("Sum with Sequential Stream: " + sum + "\n" + "Total Execution Time: " + (endTime1 - startTime1) + "ms");


        // 2. Parallel Stream: Sum of squares
        long startTime = System.currentTimeMillis();
        int numSum = numbers.parallelStream()
                .map(a -> a * a)
                .reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Sum with Parallel Stream: " + numSum + "\n" + "Total Execution Time: " + (endTime - startTime) + "ms");


        // Filtering even numbers using parallel stream
        List<Integer> evenNum = numbers.parallelStream()
                .filter((n) -> n % 2 == 0)
                .toList();
        System.out.println("Even Numbers using Parallel Stream: " + evenNum);


        // Sorting in parallel
        List<Integer> sortNum = numbers.parallelStream()
                .sorted()
                .toList();
        System.out.println("Sorted Numbers using Parallel Stream: " + sortNum);
        //vs
        List<Integer> reverseSortNum = numbers.parallelStream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Reversed Sorted Numbers using Parallel Stream: " + reverseSortNum);


        // Demonstrating that the order is not guaranteed in parallel processing
        System.out.println("Processing order demonstration:");
        numbers.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Using parallel streams for heavy computation tasks
        List<Integer> numberList = IntStream.rangeClosed(0, 1000000).boxed().toList();
        System.out.println(numberList);

        long startTime3 = System.currentTimeMillis();
        List<Integer> evenNums = numberList.parallelStream()
                .filter(n -> n % 2 == 0)
                .toList();
        long endTime3 = System.currentTimeMillis();
        System.out.println(evenNums + " ; " + (endTime3 - startTime3));
    }
}
