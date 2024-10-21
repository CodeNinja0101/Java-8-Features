Java 8 Annotations: Type & Repeating Annotations
Overview

In Java 8, two important enhancements were introduced in the annotation system:

    Type Annotations: These annotations can be applied wherever a type is used (e.g., variables, method parameters, generics).
    Repeatable Annotations: These allow the same annotation to be applied multiple times to a single element without needing an array-based container.

1. Type Annotations
   Key Concepts:

   Type annotations can be used in more places than before (e.g., within generics, casting, object creation).
   They are commonly used for code analysis tools to enforce specific constraints or validations.

Example:

@Target({ElementType.TYPE_USE})
@interface NonNull {}

class UserService {
public String getUserFullName(@NonNull String firstName, @NonNull String lastName) {
return firstName + " " + lastName;
}
}

In this example, @NonNull is used on method parameters, indicating that null values are not allowed.
Common Use Cases:

    Non-null checks with static analysis tools.
    Enhancing code clarity by marking constraints directly at the type level.

2. Repeating Annotations
   Key Concepts:

   With repeatable annotations, you no longer need to use arrays or container annotations for applying the same
   annotation multiple times.
   This is useful when applying different rules or configurations to the same element.

Example:

@Repeatable(Logs.class)
@interface Log {
String value();
}

@interface Logs {
Log[] value();
}

class UserService {
@Log("Action1")
@Log("Action2")
public void performAction() {
// method logic
}
}

In this example, @Log is used multiple times on a single method to log different actions.
Common Use Cases:

    Applying multiple logging or validation rules.
    Simplifying annotation-based configurations for methods or classes.

Practice
Folder Structure:

Java-8-Backend-Features-Practice/
├── Annotations/
│ ├── NonNullAnnotation.java
│ ├── RepeatableLogAnnotation.java
│ └── README.md

Practice Ideas:

    Implement Type Annotations for method parameters and variables to ensure constraints like non-null checks.
    Use Repeating Annotations to log multiple actions on a method using a custom logging annotation.

Advantages of Java 8 Annotations

    Type Safety: With type annotations, developers can enforce rules directly on the type system, improving the reliability of code.
    Cleaner Code: Repeating annotations simplify the syntax for applying the same annotation multiple times, leading to cleaner and more maintainable code.
    Tool Support: Annotations like @NonNull are often supported by static analysis tools like FindBugs and Lombok to automatically enforce these rules during development.
