import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class FileManager {

    public static String readFile(String filename) {
        try {
            return Files.readString(Path.of(filename));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return "";
        }
    }

    public static void writeFile(String filename, String text) {
        try {
            Files.writeString(Path.of(filename), text);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}