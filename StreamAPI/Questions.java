package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questions {
    public static void main(String[] args) {

// 1. Find 2nd highest number from List using stream
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 56, 7, 8, 9, 0, 2);
        List<Integer> num = numList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .skip(1)
                .toList();
        System.out.println("Second Highest Number: " + num);
//or
        List<Integer> num1 = numList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .stream().toList();
        System.out.println("Second Highest Number: " + num1);


// 2. Find the second-highest salary from the list of employees using stream
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
        secondHigh.ifPresent(sal -> System.out.println("Second Highest Salary: " + sal));

        if (secondHigh.isPresent()) {
            List<Map<String, Object>> empDetails = employees.stream()
                    .filter(emp -> emp.get("empSalary").equals(secondHigh.get()))
                    .toList();
            System.out.println("second high salary employee details: " + empDetails);
        } else {
            System.out.println("No second highest salary found.");
        }

//or
        List<String> secondHigh1 = employees.stream()
                .map(emp -> emp.get("empSalary").toString())
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .skip(1)
                .toList();
        System.out.println(secondHigh1);
//or


//


        // 3. Find the longest string in a list of strings using Java streams:
        List<String> strings = Arrays.asList("apple", "banana", "pineapple", "cherry");

        // Finding the longest string using streams
        Optional<String> longestString = strings.stream()
                .reduce((a, b) -> a.length() > b.length() ? a : b);

        longestString.ifPresent(s -> System.out.println("Longest String: " + s));


        //        4. Calculate the average age of a list of Person objects using Java streams:


        //        5. Check if a list of integers contains a prime number using Java streams:


//        6. Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

        // Merging and sorting two sorted lists
        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Merged Sorted List: " + mergedList);


        //        7. Find the intersection of two lists using Java streams:
        List<Integer> list11 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list12 = Arrays.asList(3, 4, 5, 6, 7);

        // Finding intersection of two lists
        List<Integer> intersection = list11.stream()
                .filter(list12::contains)
                .collect(Collectors.toList());

        System.out.println("Intersection: " + intersection);


        //        8. Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        // Removing duplicates while preserving order
        List<Integer> withoutDuplicates = numbers.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .collect(Collectors.toList());

        System.out.println("Without Duplicates: " + withoutDuplicates);


        //        9. Given a list of transactions, find the sum of transaction amounts for each day using Java streams:


//        10. Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Partitioning into even and odd numbers
        Map<Boolean, List<Integer>> partitioned = numbers1.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even Numbers: " + partitioned.get(true));
        System.out.println("Odd Numbers: " + partitioned.get(false));
    }
}