package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ParallelApiProcessor {
    AsyncServiceCaller asyncServiceCaller = new AsyncServiceCaller();

    // Process APIs using CompletableFuture with thenApply and thenAccept
    public void processApisWithMethods() throws Exception {

        // Fetch user data asynchronously
        CompletableFuture<String> userFuture = asyncServiceCaller.fetchUserData()
                .thenApply(user -> "Processed User: " + user);

        // Fetch order data and process with thenAccept
        CompletableFuture<Void> orderFuture = asyncServiceCaller.fetchOrderData()
                .thenAccept(order -> System.out.println("Order processed: " + order));

        // Fetch product data
        CompletableFuture<String> productFuture = asyncServiceCaller.fetchProductData();

        // Combine results of user and product data using thenCombine
        CompletableFuture<String> combinedFuture = userFuture.thenCombine(productFuture,
                (user, product) -> user + " & " + product);

        // Wait for all tasks to finish
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(userFuture, orderFuture, productFuture);

        // Print results when all tasks are complete
        allTasks.thenRun(() -> {
            try {
                System.out.println("Combined Result: " + combinedFuture.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).get(); // Blocking, for example, should be avoided in production
    }
}
