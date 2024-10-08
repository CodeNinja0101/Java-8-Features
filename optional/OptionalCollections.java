package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalCollections {
    public static void main(String[] args) {
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

