import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Data.Author;
import Method.ActiveWithFile;
import Method.ActiveWithFile.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String input;
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        ActiveWithFile activeWithFile = new ActiveWithFile();
        while (isRunning) {
            try {
                System.out.println("--------------------------------------");
                System.out.println("| Menu                               |");
                System.out.println("| 1. Show the list book              |");
                System.out.println("| 2. Add new book                    |");
                System.out.println("| 3. Update book                     |");
                System.out.println("| 4. Delete book                     |");
                System.out.println("| 5. Search book                     |");
                System.out.println("| 6. Store data to file              |");
                System.out.println("| 7. Add author                      |");
                System.out.println("| 8. Exit                            |");
                System.out.println("--------------------------------------");
                input = scanner.next();
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 8:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Error");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage() + ". You must enter integer");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    public void WriteToFile(){

    }
}