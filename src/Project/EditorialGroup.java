package Project;

import java.util.ArrayList;

public class EditorialGroup implements IPublishingArtifact {
    private final int ID;
    private String name;
    private ArrayList<Book> books;

    public EditorialGroup(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (book != null)
            this.books.add(book);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    /**
     * @return String in XML format which contains editorial group's information with all books from arrayList
     */
    @Override
    public String Publish() {
        String listOfBooks = "";
        for (Book book : books) {
            if (book != null)
                listOfBooks += Book.bookInformation(book);
        }

        return "<xml>\n" +
                "\t<editorialGroup>\n" +
                "\t\t<ID>" + this.getID() + "</ID>\n" +
                "\t\t<Name>" + this.getName() + "</Name>\n" +
                "\t</editorialGroup>\n" +
                "\t<books>\n" + listOfBooks + "\t</books>\n" +
                "</xml>";
    }
}
