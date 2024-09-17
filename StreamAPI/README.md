Java 8 Stream API Practice

This repository demonstrates various operations using Java 8's Stream API. The focus is on how streams can be utilized
for efficient data processing in a functional programming style.
Key Concepts

    Stream: A sequence of elements supporting aggregate operations.
    Intermediate Operations: Return a new stream and are lazy, e.g., filter(), map(), sorted().
    Terminal Operations: Produce a result or side effect, e.g., collect(), forEach(), reduce().


Stream API Examples

1. StreamBasics.java

Basic introduction to streams, including creating streams from collections and arrays.

    Creating streams
    Simple filtering and mapping
    Collecting results


2. StreamChaining.java

Demonstrates chaining multiple intermediate operations for more complex data transformations.

    Chaining operations like filter(), map(), sorted()
    Efficient processing with minimal lines of code


3. StreamReduction.java

Covers reduction operations that aggregate stream elements into a single result.

    Sum, Max, Min, Product using reduce()
    String concatenation
    Handling empty streams


4. ParallelStreams.java

Introduces parallel streams for performance improvements in large datasets.

    Using parallelStream() for parallel processing
    Demonstrating parallel reduction operations


5. StreamCollectors.java

Explores collecting the results of a stream into various collection types.

    Collectors.toList(), Collectors.toSet()
    Grouping and partitioning data with Collectors.groupingBy() and partitioningBy()


Example Usage
Basic Stream Operation

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> evenNumbers = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
    System.out.println(evenNumbers); // Output: [2, 4]


Reduction Operation

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    Integer sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);
    System.out.println("Sum: " + sum); // Output: 15


Parallel Streams

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    numbers.parallelStream()
    .forEach(System.out::println);


Getting Started

    Clone the repository:
    git clone https://github.com/your-username/Java-8-Stream-API-Practice.git