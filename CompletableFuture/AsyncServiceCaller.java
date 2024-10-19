package CompletableFuture;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class AsyncServiceCaller {

    public CompletableFuture<String> fetchUserData() {
        return CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "User Dats";
        });
    }

    public CompletableFuture<String> fetchOrderData() {
        return CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Order Data";
        });
    }

    public CompletableFuture<String> fetchProductData() {
        return CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Product Data";
        });
    }
}
