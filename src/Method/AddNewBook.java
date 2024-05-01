package Method;

import Data.Author.*;
import Data.Book;
import Data.Book.*;
import Data.BookStore;
import Data.Identifiable.*;
import Data.BookStore.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewBook {
    ActiveWithFile activeWithFile = new ActiveWithFile();
    BookStore  bookStore = new BookStore();
    public void Create(int root) {
        String regex = "^[0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        String isCountinue = "N";
        while (isCountinue.equals("N") || isCountinue.equals("n")) {
            try {
                System.out.println("Input information book.");
                System.out.println("Input ISBN: ");
                String ISBN = scanner.nextLine();
                if (!pattern.matcher(ISBN).find()) {
                    System.out.println("Error ISBN have characters");
                    break;
                }
                System.out.println("Input title: ");
                String title = scanner.nextLine();
                System.out.println("Input price: ");
                String price = scanner.nextLine();
                if (!pattern.matcher(price).find()) {
                    System.out.println("Error input characters!!!");
                    break;
                }
                System.out.println("Input authorID: ");
                String authorID = scanner.nextLine();
                Book book = new Book(ISBN,Float.parseFloat(price),title,activeWithFile.CheckAuthorExist(authorID));
                bookStore.books.add(book);
                while (isCountinue.equals("Y") || isCountinue.equals("y") || isCountinue.equals("N") || isCountinue.equals("n")) {
                    System.out.println("Back to menu: ");
                    System.out.println("Y/N");
                    isCountinue = scanner.nextLine();
                    if (isCountinue.equals("Y") || isCountinue.equals("y") || isCountinue.equals("N") || isCountinue.equals("n")) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error input");
            }
        }
    }
}
