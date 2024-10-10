Default Methods in Interfaces
Overview

Java 8 introduced default methods in interfaces, allowing interfaces to have methods with a default implementation. This feature enables adding new methods to interfaces without breaking the existing implementations of those interfaces. In this package, we explore the PaymentProcessor interface, which has two default methods—log and retry—demonstrating the flexibility and usefulness of default methods in various implementations.
Classes Overview

    PaymentProcessor: This interface represents a payment processor with default methods for logging and retry logic. It enables defining a default implementation that can be shared across different payment processor types.
    PayPalProcessor: Implements the PaymentProcessor interface and provides a custom implementation for the retry logic, specific to PayPal.
    CreditCardProcessor: Implements the PaymentProcessor interface using the default retry behavior provided by the interface, while also using custom functionality for logging.
    PaymentTest: A test class to demonstrate the behavior of each implementation. It creates instances of PayPalProcessor and CreditCardProcessor to observe how they leverage or override the default methods.

Key Concepts

    Default Methods: These methods enable adding functionality to interfaces without breaking the existing code that implements the interface.
        Syntax: A default method is defined in an interface using the default keyword.
        Purpose: Primarily used for backward compatibility, it allows adding new functionality to an interface without forcing all implementing classes to define or override the method.

    default void log(String message) {
        System.out.println("Logging: " + message);
    }

Practice Scenarios

    Logging: A shared log method to handle logging messages in a standardized way across all payment processors.
    Retry Logic: A retry method that can be overridden by specific implementations for customized retry mechanisms, or used as-is for a standard retry process.

Advantages of Default Methods

    Backward Compatibility: Allows adding new methods to existing interfaces without modifying all implementations, which is especially useful in large codebases.
    Code Reusability: Common functionality (like logging or retry logic) can be implemented once in the interface and reused across multiple implementations.
    Flexibility: Implementing classes can choose to override default methods to provide their specific behavior or retain the default functionality.

Example Usages and Explanations

    PaymentProcessor Interface:
        Contains default methods log and retry to standardize logging and retry behavior across different payment types.
        Default methods are public by design in interfaces, so there's no need to explicitly declare them as public.

    PayPalProcessor Class:
        Customizes the retry logic, demonstrating how specific implementations can override default methods as needed.

    CreditCardProcessor Class:
        Utilizes the default retry method, showing that not all implementations need to override the method if they find the default behavior sufficient.

Rules and Important Considerations

    Default Methods vs. Abstract Methods: Default methods provide an implementation, while abstract methods do not. Any class implementing an interface with abstract methods must override those methods.
    Multiple Inheritance Conflicts: If a class implements multiple interfaces with the same default method, it must override that method to resolve the conflict.
    Visibility: Default methods are inherently public and cannot be private or protected in interfaces.