Java 8 Stream API Practice

What is a Stream?

A Stream is a sequence of data elements that can be processed with various operations. Streams make it easier to handle collections of data (like lists or arrays) in a clear and declarative way.
Key Terms:

    Intermediate Operations: Transform streams, e.g., filter(), map().
    Terminal Operations: End streams, e.g., collect(), reduce().


How to Create Streams

Here are a few common ways to create streams in Java 8:

From a List or Set:

    List<String> list = Arrays.asList("apple", "banana", "cherry");
    Stream<String> stream = list.stream();

From an Array:

    String[] fruits = {"apple", "banana", "cherry"};
    Stream<String> stream = Arrays.stream(fruits);

Using Stream.of():

    Stream<String> stream = Stream.of("apple", "banana", "cherry");

Using Stream.generate(): Generate a stream with infinite elements. You can limit it using limit().

    Stream<Double> randomStream = Stream.generate(Math::random).limit(5);

Using Stream.iterate(): Generate elements by repeating a function.

    Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2).limit(5);

From Files:

    Stream<String> lines = Files.lines(Paths.get("file.txt"));


Intermediate Operations

    Filtering: filter()
    Mapping: map(), flatMap()
    Sorting: sorted()
    Distinct Elements: distinct()
    Limiting and Skipping: limit(), skip()

Terminal Operations

    Collecting Results: collect(), Collectors.toList(), Collectors.toSet()
    Reduction: reduce()
    Aggregation: count(), sum(), average()
    Matching: anyMatch(), allMatch(), noneMatch()
    Finding Elements: findFirst(), findAny()
    Iteration: forEach()

Collectors

    Grouping Elements: Collectors.groupingBy()
    Partitioning Data: Collectors.partitioningBy()
    Joining Strings: Collectors.joining()
    Mapping Collectors: Collectors.mapping()

Parallel Streams

    Parallel Processing: parallelStream()
    Performance Considerations: When to use parallel streams

Stream Pipeline

    Understanding Stream Pipelines: Combination of intermediate and terminal operations.
    Lazy Evaluation: Operations are executed when terminal operations are invoked.

Optional Handling

    Using Optional: Handling results from operations like findFirst() or findAny().

Best Practices

    Avoiding Statefulness: Avoid operations that depend on external state.
    Performance Considerations: Choosing between sequential and parallel streams.


Examples in the Repository

    StreamBasics.java: Learn basic stream creation and simple operations like filtering and mapping.

    StreamChaining.java: Chain multiple operations such as filter(), map(), and sorted() for data transformation.

    StreamReduction.java: Understand how to reduce streams to a single result, such as summing numbers or finding the maximum.

    ParallelStreams.java: Process data in parallel using parallelStream(), which is useful for performance improvement on large datasets.

    StreamCollectors.java: Collect results into different data types, such as lists, sets, or maps, and perform grouping and partitioning.



Basic Stream Operations
1. Filtering Data
 
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
        System.out.println(evenNumbers); // Output: [2, 4]


2. Reducing Data

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = numbers.stream()
        .reduce(0, Integer::sum); // Sum of numbers
        System.out.println("Sum: " + sum); // Output: 15


3. Parallel Processing

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.parallelStream()
        .forEach(System.out::println); // Prints the numbers in parallel

How to Get Started
Clone the repository:

    git clone https://github.com/your-username/Java-8-Stream-API-Practice.git


What You’ll Learn

    How to create and manipulate streams.
    How to filter, sort, map, and reduce collections of data.
    How to collect the output of streams into various data structures.
    How to process data in parallel for performance optimization.