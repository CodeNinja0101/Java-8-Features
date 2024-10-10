package DefaultMethods;

public class PaymentClass {
    public static void main(String[] args) {

        PaymentProcessor apiProcessor = new UPIProcessor();
        PaymentProcessor creditCardProcessor = new CreditCardProcessor();

        apiProcessor.processPayment(10);
        apiProcessor.retry(2);

        creditCardProcessor.processPayment(20);
        creditCardProcessor.retry(3);
    }
}
