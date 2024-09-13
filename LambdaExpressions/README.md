Java 8 Lambda Expressions - Practice
Lambda Expressions: Uses, Rules, and Importance


Uses:

    Simplifying Code: Lambda expressions provide a concise way to express instances of functional interfaces.
    Functional Programming: Enables functional programming operations like filtering, mapping, and reducing collections.
    Stream API: Essential in working with the Stream API for efficient data processing.

--------------------------------------------------------------------------------------
Rules:

    Syntax:
        Basic: (parameters) -> expression
        Multiple Statements: (parameters) -> { statements; }

    Curly Braces and Return Statements:
        Single-Line Expressions: Curly braces {} are not required if the body contains only one expression, and the return keyword is implied.
            x -> x + 5; // No curly braces needed for a single expression.

        Multiple Statements: Curly braces {} are required for multiple statements, and you must explicitly return a value if necessary.
            (x, y) -> {
                int result = x + y;
                return result;
            };

    Variable Types:
    Type Inference: The type of the parameters can usually be inferred by the compiler, so you don’t need to specify the types.
    (a, b) -> a + b;  

    Explicit Types: You can also explicitly declare the parameter types, though it's often unnecessary.
        (int a, int b) -> a + b;  // Explicit type declaration.

--------------------------------------------------------------------------------------
Importance:

    Readability: Code becomes cleaner and easier to understand.
    Less Boilerplate: Lambdas remove the need for anonymous inner classes, reducing boilerplate code.
    Efficiency: Lambdas simplify the use of streams and parallel streams, improving performance in large data processing tasks.

--------------------------------------------------------------------------------------
Class Summaries ->

LambdaBasics.java

    Demonstrates basic lambda syntax and usage.
    Key Operations:
        Creating lambda expressions for single and multiple parameters.
        Using lambda with built-in functional interfaces (Predicate, Function, Consumer).


LambdaSortingExample.java

    Demonstrates sorting with lambda expressions.
    Key Operations:
        Sorting a list of objects based on properties like name or price.
        Custom comparator using lambdas.


LambdaOtherExample.java

    Combines advanced operations using lambda and streams.
    Key Operations:
        Chaining Functions: Apply multiple operations sequentially on a value.
        Reduce Operation: Aggregate stream elements into a single result (e.g., sum, maximum).
        Parallel Streams: Execute stream operations in parallel to improve performance.
        Collecting Results into Maps: Transform a stream into a map using collectors.