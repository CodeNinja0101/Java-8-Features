package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIQuestions {

    public static void main(String[] args) {
        findSecondHighestNumber();
        findSecondHighestSalary();
        findLongestString();
        mergeTwoSortedLists();
        findIntersectionOfTwoLists();
        removeDuplicatesPreserveOrder();
        partitionListBasedOnPredicate();
    }

    // 1. Find the second highest number from the list using streams
    private static void findSecondHighestNumber() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 56, 7, 8, 9, 0, 2);
        Optional<Integer> secondHighest = numList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondHighest.ifPresent(n -> System.out.println("Second Highest Number: " + n));
    }

    // 2. Find the second highest salary from the list of employees using streams
    private static void findSecondHighestSalary() {
        List<Map<String, Object>> employees = new ArrayList<>();
        employees.add(Map.of("empId", 101, "empName", "Virat", "empSalary", 20000.0));
        employees.add(Map.of("empId", 102, "empName", "Rohit", "empSalary", 30000.0));
        employees.add(Map.of("empId", 103, "empName", "Ruturaj", "empSalary", 50000.0));
        employees.add(Map.of("empId", 104, "empName", "Ajinkya", "empSalary", 10000.0));
        employees.add(Map.of("empId", 105, "empName", "Dhoni", "empSalary", 40000.0));

        Optional<Double> secondHigh = employees.stream()
                .map(emp -> (Double) emp.get("empSalary"))
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondHigh.ifPresent(sal -> {
            System.out.println("Second Highest Salary: " + sal);
            List<Map<String, Object>> empDetails = employees.stream()
                    .filter(emp -> emp.get("empSalary").equals(sal))
                    .toList();
            System.out.println("Employees with Second Highest Salary: " + empDetails);
        });
    }

    // 3. Find the longest string in a list of strings using streams
    private static void findLongestString() {
        List<String> strings = Arrays.asList("apple", "banana", "pineapple", "cherry");

        Optional<String> longestString = strings.stream()
                .reduce((a, b) -> a.length() > b.length() ? a : b);

        longestString.ifPresent(s -> System.out.println("Longest String: " + s));
    }

    // 4. Merge two sorted lists into a single sorted list using streams
    private static void mergeTwoSortedLists() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Merged Sorted List: " + mergedList);
    }

    // 5. Find the intersection of two lists using streams
    private static void findIntersectionOfTwoLists() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> intersection = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        System.out.println("Intersection: " + intersection);
    }

    // 6. Remove duplicates from a list while preserving the order using streams
    private static void removeDuplicatesPreserveOrder() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        List<Integer> withoutDuplicates = numbers.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .collect(Collectors.toList());

        System.out.println("Without Duplicates: " + withoutDuplicates);
    }

    // 7. Partition a list into two groups based on a predicate using streams
    private static void partitionListBasedOnPredicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even Numbers: " + partitioned.get(true));
        System.out.println("Odd Numbers: " + partitioned.get(false));
    }
}
