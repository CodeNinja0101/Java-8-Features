Optional Practice - Java 8

This section covers the Optional class in Java 8, focusing on its methods and usage in various backend scenarios. The Optional class is used to handle absent values gracefully, avoid NullPointerException, and provide fallback options.
Directory Structure

mathematica

Java-8-Backend-Features-Practice/
├── Optional/
│   ├── OptionalBasics.java
│   ├── OptionalAdvanced.java
│   ├── OptionalInCollections.java
│   └── README.md

1. OptionalBasics.java
   Key Concepts

   Creation: Optional.of(), Optional.empty(), Optional.ofNullable()
   Basic Methods:
   isPresent(): Checks if a value is present.
   orElse(): Returns the value if present, otherwise returns a default value.
   orElseGet(): Returns the value if present, otherwise invokes a Supplier and returns its result.
   ifPresent(): Executes a given action if a value is present.

Example

java

Optional<String> email = Optional.ofNullable(getUserEmail());
email.ifPresent(e -> System.out.println("Sending email to: " + e));
String safeEmail = email.orElse("shri@gmail.com");

Practice

    Use Optional to handle missing data such as a user email address.
    Demonstrate how to use orElse() to provide a default email if the address is absent.

2. OptionalAdvanced.java
   Key Concepts

   Advanced Methods:
   map(): Applies a function to the value if present.
   flatMap(): Applies a function that returns an Optional.
   orElseThrow(): Throws an exception if no value is present.
   filter(): Returns an Optional describing the value if it matches a predicate, otherwise returns an empty Optional.

Example

java

Optional<User> user = Optional.ofNullable(findUser());
String email = user.filter(User::isActive)
.flatMap(User::getEmail)
.orElse("no-email@example.com");

Practice

    Use filter() to work with specific user criteria (e.g., only active users).
    Apply orElseThrow() to handle cases where essential data is missing, and an exception should be thrown.

3. OptionalInCollections.java
   Key Concepts

   Stream Integration:
   findFirst(): Returns an Optional describing the first element of a stream, or an empty Optional if the stream is empty.
   Using map() in streams to transform data if present.
   Combining Optional with stream operations like filter() to handle conditional logic.

Example

java

List<Integer> numbers = Arrays.asList(3, 7, 10, 2, 5);
Optional<Integer> firstEven = numbers.stream()
.filter(n -> n % 2 == 0)
.findFirst();
int result = firstEven.map(n -> n * 2).orElse(-1);

Practice

    Find the first even number in a list and double it.
    Use orElse() with stream operations to provide default values if a condition is not met.

Summary

The Optional class provides a more functional approach to handle null values in Java. By practicing with Optional, you can avoid common pitfalls such as NullPointerException and write cleaner, more readable code. Each class in this section demonstrates practical usage of Optional with backend data handling in mind.