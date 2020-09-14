package ru.kykyis;
import ru.kykyis.decryptor.*;
import ru.kykyis.repository.*;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //считываем файл
        File encryptedFile = null;
        try {
            encryptedFile = new File(Main.class.getResource("/text.txt").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        BufferedReader reader = null;
        List<Character> list = null;
        char charSymbol;
        try {
            reader = new BufferedReader(new FileReader(encryptedFile));
            list = new ArrayList<Character>();
            int symbol;
            while ((symbol = reader.read()) != -1) {
                charSymbol = (char) symbol;
                list.add(charSymbol);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




        // начинаем расшифровку
        CharListRepository charListRepository = new CharListRepository(list);
        AlphabetListRepository alphabet = new AlphabetListRepository();
        CharListRepository newCharList = null;

        int shift = 0;
        int choice = 0;

        while (choice != 1337) {

            newCharList = new CharListRepository(DecryptoMachine.encrypt(alphabet, charListRepository.getList(), shift));
            newCharList.printList();
            System.out.println("\n\nСдвиг установлен на " + shift + "\n");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите 1/0 чтобы увеличить/уменьшить сдвиг.");
            System.out.println("Введите 1337 чтобы выйти.");
            System.out.print("Введите число:");

            choice = scanner.nextInt();
            switch (choice) {
                case (1):
                    shift++;
                    break;
                case (0):
                    shift--;
                    break;
                default:
                    break;
            }
            System.out.print("\n");
        }
    }
}
