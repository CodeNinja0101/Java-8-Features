package base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Base64BinaryData {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Krushna\\Downloads\\Microservice.png";

        try (FileInputStream imageInputStream = new FileInputStream(filePath)) {
            byte[] imageBytes = imageInputStream.readAllBytes();

            // Encode image bytes to Base64
            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
            System.out.println("Encoded Image: " + encodedImage);

            // Decode back to bytes
            byte[] decodedImageBytes = Base64.getDecoder().decode(encodedImage);
            System.out.println("Decoded bytes length: " + decodedImageBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
