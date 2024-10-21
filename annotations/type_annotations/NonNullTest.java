package annotations.type_annotations;

public class NonNullTest {
    public static void main(String[] args) {
        NonNull.UserService userService = new NonNull.UserService();

        String fullName = userService.getUserFullName("Shri", "Ghumre");
        System.out.println("User's full name: " + fullName);

        try {
            String nullFirstName = userService.getUserFullName(null, "Ghumre");
        } catch (NullPointerException e) {
            System.err.println("Caught exception for first name: " + e.getMessage());
        }

        try {
            String invalidFullName = userService.getUserFullName("Shri", null);
        } catch (NullPointerException e) {
            System.err.println("Caught exception for last name: " + e.getMessage());
        }
    }
}
