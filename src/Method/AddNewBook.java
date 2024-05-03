package Method;

import Data.Author;
import Data.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CheckedOutputStream;

public class AddNewBook {
    String line;
    FileReader fileReader;
    BufferedReader bufferedReader;
    public List<Book> books = new ArrayList<>();
    public String[] oldBook;
    public void Create(int root) {
        String regex = "^[0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        String isCountinue = "N";
        while (isCountinue.equals("N")) {
            try {
                System.out.println("Input information book.");
                System.out.println("Input ISBN: ");
                String ISBN = scanner.nextLine();
                if (ISBN.equals("") && root ==1){
                    System.out.println("Please input ISBN");
                    continue;
                }
                if (ISBN.equals("") && root ==2){
                    ISBN = oldBook[0];
                }
                if (!pattern.matcher(ISBN).find()) {
                    System.out.println("Error ISBN have characters");
                    continue;
                }
                System.out.println("Input title: ");
                String title = scanner.nextLine();
                if (title.equals("")&& root == 2){
                    title = oldBook[1];
                }
                if (title.equals("") && root ==1){
                    System.out.println("Please input title");
                    continue;
                }
                System.out.println("Input price: ");
                String price = scanner.nextLine();
                if (price.equals("") && root == 1){
                    System.out.println("Please input price");
                    continue;
                }
                if (price.equals("") && root == 2){
                    price = oldBook[2];
                }
                if (!pattern.matcher(price).find()) {
                    System.out.println("Error input characters!!!");
                    continue;
                }
                System.out.println("Input authorID: ");
                String authorID = scanner.nextLine();
                if (authorID.equals("") && root == 1){
                    System.out.println("Please input authorID");
                    continue;
                }
                if (authorID.equals("") && root == 2){
                    authorID = oldBook[4];
                }
                Book book = new Book(ISBN,Float.parseFloat(price),title,CheckAuthorExistInFile(authorID));
                if (CheckExistInList(book) || CheckISBNExistInFile(ISBN)){
                    System.out.println("ISBN duplicate!!!");
                }
                else {
                    books.add(book);
                }
                if (root == 1){
                    while (isCountinue.equals("Y") || isCountinue.equals("N") ) {
                        System.out.println("Back to menu: ");
                        System.out.println("Y/N");
                        isCountinue = scanner.nextLine().toUpperCase();
                        if (isCountinue.equals("Y")  || isCountinue.equals("N") ) {
                            break;
                        }
                    }
                }
                isCountinue = "Y";

            } catch (Exception e) {
                System.out.println("Error input");
            }
        }
    }
    public boolean CheckExistInList(Book book){
        for (int i =0 ; i < books.size(); i++){
            if (book.getId().equals(books.get(i).getId())){
                return true;
            }
        }
        return false;
    }
    public Author CheckAuthorExistInFile(String authorName){
        try {
            Author author = null;
            fileReader = new FileReader("author.dat");
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(" - ");
                if (authorName.equals(parts[0])){
                    author = new Author(parts[0], parts[1]);
                    break;
                }
            }
            return author;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean CheckISBNExistInFile(String ISBN){
        try {
            fileReader = new FileReader("book.dat");
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(" - ");
                if (ISBN.equals(parts[0])){
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
