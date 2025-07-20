import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Зашифровать текст");
            System.out.println("2 - Расшифровать текст");
            System.out.println("3 - Взломать шифр перебором (brute force)");
            System.out.println("4 - Выйти");
            System.out.print("Введите номер: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Введите имя файла с текстом: ");
                String inputFile = scanner.nextLine();

                if (!Validator.fileExists(inputFile)) {
                    System.out.println("Файл не найден. Попробуйте снова.");
                    continue;
                }

                System.out.print("Введите ключ (число): ");
                String keyStr = scanner.nextLine();

                if (!Validator.isValidKey(keyStr, Cipher.ALPHABET.length())) {
                    System.out.println("Неверный ключ. Попробуйте снова.");
                    continue;
                }

                int key = Integer.parseInt(keyStr);
                String text = FileManager.readFile(inputFile);
                String encrypted = Cipher.encrypt(text, key);

                System.out.print("Введите имя файла для сохранения зашифрованного текста: ");
                String outputFile = scanner.nextLine();
                FileManager.writeFile(outputFile, encrypted);
                System.out.println("Текст зашифрован и сохранён.");

            } else if (choice.equals("2")) {
                System.out.print("Введите имя файла с зашифрованным текстом: ");
                String inputFile = scanner.nextLine();

                if (!Validator.fileExists(inputFile)) {
                    System.out.println("Файл не найден. Попробуйте снова.");
                    continue;
                }

                System.out.print("Введите ключ (число): ");
                String keyStr = scanner.nextLine();

                if (!Validator.isValidKey(keyStr, Cipher.ALPHABET.length())) {
                    System.out.println("Неверный ключ. Попробуйте снова.");
                    continue;
                }

                int key = Integer.parseInt(keyStr);
                String text = FileManager.readFile(inputFile);
                String decrypted = Cipher.decrypt(text, key);

                System.out.print("Введите имя файла для сохранения расшифрованного текста: ");
                String outputFile = scanner.nextLine();
                FileManager.writeFile(outputFile, decrypted);
                System.out.println("Текст расшифрован и сохранён.");

            } else if (choice.equals("3")) {
                System.out.print("Введите имя файла с зашифрованным текстом: ");
                String inputFile = scanner.nextLine();

                if (!Validator.fileExists(inputFile)) {
                    System.out.println("Файл не найден. Попробуйте снова.");
                    continue;
                }

                String text = FileManager.readFile(inputFile);
                System.out.println("Начинаем перебор ключей...");
                BruteForce.crackAll(text);
                System.out.println("Перебор закончен.");

            } else if (choice.equals("4")) {
                System.out.println("Выход из программы. Пока!");
                scanner.close();
                break;

            } else {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}