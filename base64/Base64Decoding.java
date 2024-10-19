package base64;

import java.util.Base64;

public class Base64Decoding {
    public static void main(String[] args) {
        String encodedString = "UGFzc3dvcmRAMTIz";
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded string: " + decodedString);
    }
}
