package Method;

import Data.Author;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActiveWithFile {
    String line;
    FileReader fileReader;
    BufferedReader bufferedReader;
    public Author CheckAuthorExist(String authorName){
        try {
            Author author = null;
            fileReader = new FileReader("author.dat");
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                String[] parts = line.split(" - ");
                System.out.println(line);
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
}
