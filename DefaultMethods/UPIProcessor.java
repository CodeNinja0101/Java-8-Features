package DefaultMethods;

public class UPIProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of RS" + amount);
        log("UPI payment processed successfully.");
    }

    @Override
    public void retry(int retries) {
        System.out.println("UPI-specific retry logic, up to " + retries + " times.");
        for (int i = 1; i <= retries; i++) {
            System.out.println("Attempt " + i + " to process payment.");
        }
        log("Retried " + retries + " times.");
    }
}
