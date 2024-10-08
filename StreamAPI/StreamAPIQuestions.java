package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIQuestions {

    public static void main(String[] args) {
        findSecondHighestNumber();
        findSecondHighestSalary();
        findLongestString();
        calculateAverageAge();
        checkForPrimeNumber();
        mergeTwoSortedLists();
        findIntersectionOfTwoLists();
        removeDuplicatesPreserveOrder();
        sumTransactionsPerDay();
        partitionListBasedOnPredicate();
    }

    // 1. Find the second-highest number from the list using streams
    private static void findSecondHighestNumber() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 56, 7, 8, 9, 0, 2);
        Optional<Integer> secondHighest = numList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondHighest.ifPresent(n -> System.out.println("Second Highest Number: " + n));
    }

    // 2. Find the second-highest salary from the list of employees using streams
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

    // 4. Calculate the average age of a list of Person objects using Java streams
    private static void calculateAverageAge() {
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Tom", 35)
        );

        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

        System.out.println("Average Age: " + averageAge);
    }

    // 5. Check if a list of integers contains a prime number using Java streams
    private static void checkForPrimeNumber() {
        List<Integer> numbers = Arrays.asList(4, 6, 8, 9, 11);

        boolean hasPrime = numbers.stream().anyMatch(StreamAPIQuestions::isPrime);

        System.out.println("Contains Prime Number: " + hasPrime);
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // 6. Merge two sorted lists into a single sorted list using streams
    private static void mergeTwoSortedLists() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .toList();

        System.out.println("Merged Sorted List: " + mergedList);
    }

    // 7. Find the intersection of two lists using streams
    private static void findIntersectionOfTwoLists() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> intersection = list1.stream()
                .filter(list2::contains)
                .toList();

        System.out.println("Intersection: " + intersection);
    }

    // 8. Remove duplicates from a list while preserving the order using streams
    private static void removeDuplicatesPreserveOrder() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        List<Integer> withoutDuplicates = numbers.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .toList();

        System.out.println("Without Duplicates: " + withoutDuplicates);
    }

    // 9. Sum of transaction amounts for each day using streams
    private static void sumTransactionsPerDay() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2024-09-18", 200),
                new Transaction("2024-09-18", 300),
                new Transaction("2024-09-19", 150)
        );

        Map<String, Integer> sumPerDay = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getDate,
                        Collectors.summingInt(Transaction::getAmount)
                ));

        System.out.println("Sum of Transactions per Day: " + sumPerDay);
    }

    // 10. Partition a list into two groups based on a predicate using streams
    private static void partitionListBasedOnPredicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even Numbers: " + partitioned.get(true));
        System.out.println("Odd Numbers: " + partitioned.get(false));
    }

    // Supporting class for calculateAverageAge()
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    // Supporting class for sumTransactionsPerDay()
    static class Transaction {
        private String date;
        private int amount;

        public Transaction(String date, int amount) {
            this.date = date;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public int getAmount() {
            return amount;
        }
    }




//    questions soved in the class:
//
//            1. Find the second-highest number from the list using streams.
//
//            2. Find the second-highest salary from the list of employees using streams.
//
//            3. Find the longest string in a list of strings using streams.
//
//            4. Calculate the average age of a list of Person objects using Java streams.
//
//            5. Check if a list of integers contains a prime number using Java streams.
//
//            6. Merge two sorted lists into a single sorted list using streams.
//
//            7. Find the intersection of two lists using streams.
//
//            8. Remove duplicates from a list while preserving the order using streams.
//
//            9. Given a list of transactions, find the sum of transaction amounts for each day using streams.
//
//            10. Implement a method to partition a list into two groups based on a predicate using streams.

}
