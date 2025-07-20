public class Cipher {
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = ALPHABET.indexOf(ch);

            if (index == -1) {
                result.append(ch);
            } else {
                int newIndex = (index + key) % ALPHABET.length();
                result.append(ALPHABET.charAt(newIndex));
            }
        }
        return result.toString();
    }


    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = ALPHABET.indexOf(ch);

            if (index == -1) {
                result.append(ch);
            } else {
                int newIndex = (index - key + ALPHABET.length()) % ALPHABET.length();
                result.append(ALPHABET.charAt(newIndex));
            }
        }
        return result.toString();
    }
}