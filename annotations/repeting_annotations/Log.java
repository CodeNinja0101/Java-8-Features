package annotations.repeting_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the repeatable annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// Reference to the container annotation
@Repeatable(Logs.class)
public @interface Log {
    String value();
}

// Define the container annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Logs {
    Log[] value();
}
