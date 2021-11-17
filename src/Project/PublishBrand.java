package Project;

import java.util.ArrayList;

public class PublishBrand implements IPublishingArtifact{
    private final int ID;
    private String name;
    private ArrayList<Book> books;

    public PublishBrand(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book){
        if(book != null)
            this.books.add(book);
    }

    public void setBooks(ArrayList books) {
        this.books = books;
    }

    @Override
    public String Publish() {
        String listOfBooks = "";
        for(Book book: books) {
            if(book != null)
                listOfBooks += Book.bookInformation(book);
        }

        return "<xml>\n" +
                "\t<publishingBrand>\n" +
                "\t\t<ID>" + this.getID() + "</ID>\n" +
                "\t\t<Name>" + this.getName() + "</Name>\n" +
                "\t</publishingBrand>\n" +
                "\t<books>\n" +
                listOfBooks +
                "\t</books>\n" +
                "</xml>";
    }
}
