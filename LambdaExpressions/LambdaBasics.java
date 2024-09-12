package LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaBasics {
    public static void main(String[] args) {
        //Lambda expression
        Runnable r = () -> System.out.println("This is Lambda Expression!");
        r.run();


        //Lambda in Collections
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        //Filtering
        List<Integer> evenNumber = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
//                .toList();
        System.out.println("Even Numbers: "+evenNumber);


        //Mapping
        List<String> numbersStrings = numbers.stream()
                .map(n -> "numbers "+n)
                .toList();
        System.out.println("Number Strings: "+numbersStrings);
    }
}
