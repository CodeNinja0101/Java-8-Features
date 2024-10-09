package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalCollections {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Shri", false, "shri@gmail.com"),
                new User("Saggy", true, null),
                new User("Nandu", true, "nd@gmail.com"),
                new User("Ajit", false, null)
        );

        // Find the first active user
        Optional<User> firstActiveUser = users.stream()
                .filter(User::isActive)
                .findFirst();
        firstActiveUser.ifPresent(user -> System.out.println("First active user found: " + user.getName()));

        // Find user by name, with a default if not found
        String userName = "sk";
        User userByName = users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(userName))
                .findFirst()
                .orElse(new User("Default user", false, "default@gmail.com"));
        System.out.println("User found or default: " + userByName.getName());

        // Example: Get the email of the first user, providing a default if missing
        users.stream()
                .map(User::getEmail)
                .map(Optional::ofNullable)
                .forEach(emailOps -> System.out.println("User Email:- " + emailOps.orElse(Optional.of("No email available"))));


        List<Integer> numbers = Arrays.asList(3, 7, 10, 2, 5);

        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();

        int doubledEven = firstEven.map(n -> n * 2)
                .orElse(0);
        System.out.println("Doubled first even number: " + doubledEven);

        int result = numbers.stream()
                .filter(n -> n > 100)
                .findFirst()
                .orElse(-1);
        System.out.println("First number over 100: " + result);

    }
}

