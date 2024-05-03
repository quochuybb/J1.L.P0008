import java.io.FileNotFoundException;
import java.util.*;

import Method.ActiveWithFile;
import Method.AddNewBook;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String input;
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        AddNewBook addNewBook = new AddNewBook();
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
                        activeWithFile.ShowTheBookList();
                        break;
                    case 2:
                        addNewBook.Create(1);
                        break;
                    case 3:
                        System.out.println("Enter Book ID to update:");
                        input = scanner.next();
                        activeWithFile.UpdateInfo(input);
                        break;
                    case 4:
                        System.out.println("Enter Book ID to delete:");
                        input = scanner.next();
                        activeWithFile.DeleteInfo(input);
                        break;
                    case 5:
                        activeWithFile.FindInfo();
                        break;
                    case 6:
                        for (int i = 0 ; i < addNewBook.books.size(); i++){
                            List<String> line = new ArrayList<>();
                            line.add(addNewBook.books.get(i).getId());
                            line.add(addNewBook.books.get(i).getTitle());
                            line.add(Float.toString(addNewBook.books.get(i).getPrice()));
                            line.add(addNewBook.books.get(i).getAuthor().getName());
                            line.add(addNewBook.books.get(i).getAuthor().getId());
                            activeWithFile.WriteTextToFile(line);
                        }
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
}