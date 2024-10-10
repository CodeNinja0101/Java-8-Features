package DefaultMethods;

public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of RS: " + amount);
        log("Credit Card payment processed successfully.");
    }

    @Override
    public void retry(int retries) {
        System.out.println("Credit Card-specific retry payment, up to " + retries + " times.");
        for (int i = 1; i <= retries; i++) {
            System.out.println("Attempt " + i + " to process payment.");
        }
        log("Retried " + retries + " times.");
    }
}
