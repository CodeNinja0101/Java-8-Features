package lambda_expressions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaOtherExample {

    public static void main(String[] args) {
        List<Accessories> accessories = Arrays.asList(
                new Accessories("Laptop", 1200.00),
                new Accessories("Smartphone", 800.00),
                new Accessories("Tablet", 300.00),
                new Accessories("Monitor", 150.00),
                new Accessories("Keyboard", 50.00)
        );

        System.out.println(accessories);

        // 1. Chaining Functions: Square the price, then add 10
        Function<Double, Double> squarePrice = price -> price * price;
        Function<Double, Double> addTen = price -> price + 10;

        Function<Double, Double> squareThenAddTen = squarePrice.andThen(addTen);
        System.out.println("Chained Function Result (Laptop Price): " + squareThenAddTen.apply(accessories.get(0).getPrice()));


        // 2. Reduce Operation: Sum all product prices
        Double accessoriesTotal = accessories.stream()
                .map(Accessories :: getPrice)
                .reduce(0.0, (a, b) -> a + b);
        System.out.println("Total Price of Accessories: "+accessoriesTotal);


        // 3. Parallel Streams: Process the product names in parallel and convert them to uppercase
        List<String> accessoriesNames = accessories.parallelStream()
//                .map(Accessories :: getPrice)
                .map(Accessories :: getName)
                .map(String :: toUpperCase)
                .toList();
        System.out.println("Product Names in Uppercase (Parallel Stream): " + accessoriesNames);


        Map<String, Double> productPriceMap = accessories.stream()
                .collect(Collectors.toMap(Accessories :: getName, Accessories :: getPrice));
        System.out.println("Product-Price Map: " + productPriceMap);
    }
}



// Helper Class for Product
class Accessories {
    private String name;
    private double price;

    public Accessories(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}
