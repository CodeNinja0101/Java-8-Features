package LambdaExpressions;

public class LambdaBasics {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("This is Lambda Expression!");
        r.run();
    }
}
