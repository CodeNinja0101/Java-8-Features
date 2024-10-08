package optional;

import java.util.Optional;

public class OptionalBasics {
    public static void main(String[] args) {

        Optional<String> email = Optional.ofNullable(getUserEmail());

        // Checking if a value is present
        if (email.isPresent()) {
            System.out.println("Email is: " + email.get());
        } else {
            System.out.println("Email not found");
        }

        // Using orElse to provide a default
        String emailValue = email.orElse("demo@gmail.com");
        System.out.println("Email: " + emailValue);

        // Using ifPresent to perform an action
        email.ifPresent(e -> System.out.println("Sending email to: " + e));
    }

    private static String getUserEmail() {
        return null; // Simulate a missing value
    }

}
