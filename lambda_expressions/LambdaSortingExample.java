package lambda_expressions;

import java.util.Arrays;
import java.util.List;

public class LambdaSortingExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 80000),
                new Product("Mouse", 2000),
                new Product("Speaker", 3000),
                new Product("Keyboard", 5000),
                new Product("Keyboard", 5000)
        );


        //sort ny ascending order
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Products sorted by price (ascending): " + products);

//        products.sort((p1, p2) -> (Double.compare(p2.getPrice(), p1.getPrice())));
//        System.out.println("Products sorted by price (descending): " + products);

        //ascending
//        products.sort((p1, p2) -> {
//                    int priceCompare = Double.compare(p1.getPrice(), p2.getPrice());
//                    if (priceCompare == 0) {
//                        return p1.getName().compareTo(p2.getName());
//                    } else {
//                        return priceCompare;
//                    }
//                }
//        );
//        for (Product product : products){
//            System.out.println(product);
//        }


        //descending
        products.sort((p1, p2) -> {
                    int priceCompare2 = Double.compare(p2.getPrice(), p1.getPrice());
                    if (priceCompare2 == 0) {
                        return p1.getName().compareTo(p2.getName());
                    } else {
                        return priceCompare2;
                    }
                }
        );

        products.forEach(System.out::println);
        }
    }




class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
