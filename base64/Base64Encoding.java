package base64;

import java.util.Base64;

public class Base64Encoding {
    public static void main(String[] args) {
        String data = "Password@123";
        String encoded = Base64.getEncoder().encodeToString(data.getBytes());
        System.out.println("Encoded string: " + encoded);
    }
}