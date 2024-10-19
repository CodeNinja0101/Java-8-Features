package CompletableFuture;

public class ApiCallTest {
    public static void main(String[] args) throws Exception {
        ParallelApiProcessor processor = new ParallelApiProcessor();

        // Process asynchronous API calls with CompletableFuture methods
        processor.processApisWithMethods();
    }
}
