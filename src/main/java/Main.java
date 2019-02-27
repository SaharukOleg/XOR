import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        cipherEncryption();
        cipherDecryption();

    }

    private static void cipherEncryption() {
        System.out.print("Enter message ");
        String message = in.nextLine();

        System.out.print("Enter key ");
        String key = in.nextLine();

        String encrypHexa = "";
        int keyItr = 0;

        for (int i = 0; i < message.length(); i++) {
            int tmp = message.charAt(i) ^ key.charAt(keyItr);

            encrypHexa += String.format("%02x", (byte) tmp);
            keyItr++;
            if (keyItr >= key.length()) {
                keyItr = 0;
            }
        }

        System.out.println("Encrypted Text " + encrypHexa);
    }


    private static void cipherDecryption() {
        System.out.print("Enter message ");
        String message = in.nextLine();

        System.out.print("Enter key ");
        String key = in.nextLine();


        String hexToDeci = "";
        for (int i = 0; i < message.length() - 1; i += 2) {
            String output = message.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            hexToDeci += (char) decimal;
        }
        // decryption
        String decrypText = "";
        int keyItr = 0;

        for (int i = 0; i < hexToDeci.length(); i++) {
            int tmp = hexToDeci.charAt(i) ^ key.charAt(keyItr);

            decrypText += (char) tmp;
            keyItr++;
            if (keyItr >= key.length()) {
                keyItr = 0;
            }
        }

        System.out.println("Decrypted Text " + decrypText);
    }


}
