public class BruteForce {

    public static void crackAll(String text) {
        for (int key = 1; key < Cipher.ALPHABET.length(); key++) {
            String decrypted = Cipher.decrypt(text, key);
            System.out.println("Ключ " + key + ": " + decrypted);
        }
    }
}