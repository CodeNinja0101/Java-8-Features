CompletableFuture and Concurrency Enhancements
Overview

This project demonstrates the usage of CompletableFuture in Java 8+ to handle non-blocking, asynchronous programming. We simulate multiple asynchronous API calls in parallel and demonstrate methods like supplyAsync(), thenApply(), thenAccept(), and allOf() to handle concurrent tasks efficiently.
Classes Overview
1. AsyncServiceCaller

   Simulates multiple API calls (e.g., user data, order data, product data) that run asynchronously using CompletableFuture.supplyAsync().
   Each method returns a CompletableFuture that represents the result of the asynchronous operation.

2. ParallelApiProcessor

   Demonstrates how to use different CompletableFuture methods like thenApply(), thenAccept(), and allOf() to process asynchronous results.
   Combines multiple API call results and processes them in parallel using the thenCombine() method.

3. ApiCallTest

   Entry point to test and observe the execution of asynchronous API calls and result processing.
   Calls the methods from ParallelApiProcessor to demonstrate various CompletableFuture methods.

Project Structure

css

completablefuture-demo
│
├── src
│   ├── main
│   │   └── java
│   │       ├── AsyncServiceCaller.java
│   │       ├── ParallelApiProcessor.java
│   │       └── ApiCallTest.java
│
└── README.md

Key Methods and Concepts
1. supplyAsync()

   Used to asynchronously execute a task in a separate thread without blocking the main thread.
   Example:

   CompletableFuture<String> userFuture = serviceCaller.fetchUserData();

2. thenApply()

   Transforms the result of a CompletableFuture once it completes.
   Example:

   userFuture.thenApply(user -> "Processed User: " + user);

3. thenAccept()

   Consumes the result of a CompletableFuture without returning anything.
   Example:

   orderFuture.thenAccept(order -> System.out.println("Order processed: " + order));

4. thenCombine()

   Combines the results of two CompletableFuture instances.
   Example:

   combinedFuture = userFuture.thenCombine(productFuture,
   (user, product) -> user + " & " + product);

5. allOf()

   Waits for all given CompletableFuture instances to complete before executing further logic.
   Example:

   CompletableFuture<Void> allTasks = CompletableFuture.allOf(userFuture, orderFuture, productFuture);

6. thenRun()

   Executes a Runnable action after the completion of a set of CompletableFuture tasks.
   Example:

   allTasks.thenRun(() -> {
   try {
   System.out.println("Combined Result: " + combinedFuture.get());
   } catch (Exception e) {
   e.printStackTrace();
   }
   });

Practice Exercise

The project demonstrates the following use case:

    Problem: You need to make multiple API calls in parallel for a microservice and process their results.
    Solution: Use CompletableFuture to execute API calls asynchronously, process their results with transformation methods like thenApply(), and finally wait for all tasks to complete using allOf().

Steps in the Example:

    Make asynchronous API calls to fetch user, order, and product data.
    Use thenApply() to modify the result of the user data after it’s retrieved.
    Use thenAccept() to log the order data.
    Combine the results of user and product data using thenCombine().
    Wait for all API calls to complete using allOf() and print the combined result.

Execution

To run the project, execute the ApiCallTest.java class. You should observe the output from all the asynchronous API calls being processed in parallel.
Sample Output:

sql

Order processed: Order Data
Combined Result: Processed User: User Data & Product Data

Advantages of CompletableFuture

    Non-blocking Execution: Executes tasks asynchronously, improving application performance by avoiding thread blocking.
    Chained Operations: Supports chaining of multiple tasks with methods like thenApply(), thenAccept(), thenCombine().
    Concurrent Task Management: Manages multiple concurrent tasks easily with a functional programming style.
    Improved Error Handling: Handles exceptions with methods like exceptionally() or handle() without breaking the flow of tasks.

Important Notes

    By default, CompletableFuture.supplyAsync() uses the ForkJoinPool.commonPool() for parallel task execution. A custom thread pool can also be provided.
    Blocking operations (e.g., .get()) should be avoided in production. It’s used here for simplicity in demonstration.
    CompletableFuture provides better readability and flexibility compared to traditional concurrency mechanisms like Future.