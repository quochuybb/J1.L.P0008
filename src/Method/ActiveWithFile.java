package Method;

import Data.Author;
import Data.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ActiveWithFile {
    String line;
    FileReader fileReader;
    BufferedReader bufferedReader;
    AddNewBook addNewBook = new AddNewBook();

    public void WriteTextToFile(List<String> line){
        for (int i =0 ; i < line.size(); i++){
            try {
                FileWriter printWrite = new FileWriter("book.dat", true);
                if (i == line.size() -1){
                    printWrite.write(line.get(i) + "\n");
                }
                else {
                    printWrite.write(line.get(i) + " - ");
                }
                printWrite.flush();
                printWrite.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void ShowTheBookList(){
        try {
            Author author = null;
            fileReader = new FileReader("book.dat");
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void UpdateInfo(String ISBN){
        DeleteInfo(ISBN);
        addNewBook.Create(2);
        for (int i = 0 ; i < addNewBook.books.size(); i++){
            List<String> line = new ArrayList<>();
            line.add(addNewBook.books.get(i).getId());
            line.add(addNewBook.books.get(i).getTitle());
            line.add(Float.toString(addNewBook.books.get(i).getPrice()));
            line.add(addNewBook.books.get(i).getAuthor().getName());
            line.add(addNewBook.books.get(i).getAuthor().getId());
            WriteTextToFile(line);
        }
    }
    public void FindInfo(){
        try {
            FileReader fileReader = new FileReader("book.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("Enter name book:");
            Scanner scanner = new Scanner(System.in);
            String Name = scanner.next();
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(" - ");
                if (parts[1].toUpperCase().contains(Name.toUpperCase()) ){
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void DeleteInfo(String ISBN){
        List<List<String>> lines = new ArrayList<>();
        String isCountinue;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Continue: ");
            System.out.println("Y/N");
            isCountinue = scanner.nextLine().toUpperCase();
            if (isCountinue.equals("N") ){
                return;
            } else if (isCountinue.equals("Y") ) {
                break;
            }
        }
        if (!addNewBook.CheckISBNExistInFile(ISBN)){
            System.out.println("Book does not exist");
            System.out.println("Delete Fail");
            return;
        }
        try {
            FileReader fileReader = new FileReader("book.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(" - ");
                if (ISBN.equals(parts[0])){
                    addNewBook.oldBook = parts;
                    continue;
                }
                List<String> newparts =  Arrays.asList(parts);
                lines.add(newparts);
            }
            FileWriter clearFile = new FileWriter("book.dat", false);
            clearFile.flush();
            clearFile.close();
            for (int i = 0;i < lines.size();i++){
                WriteTextToFile(lines.get(i));
            }
            System.out.println("Delete Success");
        } catch (IOException e) {
            System.out.println("Delete Fail");
            throw new RuntimeException(e);
        }

    }

}
