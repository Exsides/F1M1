import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public static boolean fileExists(String filename) {
        return Files.exists(Path.of(filename));
    }

    public static boolean isValidKey(String keyStr, int alphabetLength) {
        try {
            int key = Integer.parseInt(keyStr);
            if (key > 0 && key < alphabetLength) {
                return true;
            }
        } catch (NumberFormatException e) {

        }
        return false;
    }
}