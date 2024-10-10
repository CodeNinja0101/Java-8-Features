package DefaultMethods;

public interface PaymentProcessor {
    void processPayment(double amount);

    default void log(String message) {
        System.out.println("Logging: " + message);
    }

    default void retry(int retries) {
        System.out.println("Retrying operation up to " + retries + " times.");
    }
}
