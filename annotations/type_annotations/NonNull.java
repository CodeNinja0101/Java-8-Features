package annotations.type_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

// Define a custom @NonNull annotation
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
// Make it available at runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface NonNull {

    class UserService {

        public String getUserFullName(@NonNull String firstName, @NonNull String lastName) {
            // Optionally enforce null checks
            Objects.requireNonNull(firstName, "First Name cannot be null");
            Objects.requireNonNull(lastName, "Last Name cannot be null");
            return firstName + " " + lastName;
        }
    }
}
