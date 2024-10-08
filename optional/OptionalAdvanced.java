package optional;

import java.util.Map;
import java.util.Optional;

public class OptionalAdvanced {
    public static void main(String[] args) {

        Optional<User> user = Optional.of(findUser());
        Optional<String> email = user.filter(User::isActive)
                .flatMap(User::getEmail);

        email.ifPresentOrElse(
                e -> System.out.println("User email: " + e),
                () -> System.out.println("No email found for active user")
        );

        User foundUser = user.orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("User found: " + foundUser.getName());
    }

    private static User findUser() {
        return new User("Shri", true, "shri@gmail.com");
    }

}

class User {
    private String name;
    private boolean active;
    private String email;

    public User(String name, boolean active, String email) {
        this.name = name;
        this.active = active;
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public String getName() {
        return name;
    }
}
