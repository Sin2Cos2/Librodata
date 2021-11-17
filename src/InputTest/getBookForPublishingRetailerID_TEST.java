package InputTest;

import Project.Administration;
import Project.Book;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class getBookForPublishingRetailerID_TEST {

    public static void test(Administration administration, String path, int retailerID){
        ArrayList<Book> books = administration.getBooksForPublishingRetailerID(retailerID);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write("Total books: " + books.size() + "\n");
            for(Book book : books)
                bw.write(book.Publish() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
