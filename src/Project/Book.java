package Project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Book implements IPublishingArtifact{
    private final int ID;
    private String name;
    private String subtitle;
    private final String ISBN;
    private int pageCount;
    private String keywords;
    private int languageID;
    private Calendar createdOn;
    private ArrayList<Author> authors;

    public Book(int ID, String name, String subtitle, String ISBN, int pageCount, String keywords, int languageID,
                Calendar createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public void setAuthors(ArrayList authors) {
        this.authors = authors;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public String getCreatedOn() {
        Date date = this.createdOn.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String strDate =dateFormat.format(date);
        return strDate;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author){
        if(author != null)
            this.authors.add(author);
    }

    public String getListOfAuthors(){
        if(authors.size() == 0)
            return "";

        String tempAuthors = "";
        for(Author author : authors)
            tempAuthors += author.getFirstName() + " " + author.getLastName() + ",";
        tempAuthors = tempAuthors.substring(0, tempAuthors.length() - 1);

        if(tempAuthors.charAt(tempAuthors.length() - 1) == ' ')
            tempAuthors = tempAuthors.substring(0, tempAuthors.length() - 1);
        if(tempAuthors.charAt(0) == ' ')
            tempAuthors = tempAuthors.substring(1, tempAuthors.length());

        return tempAuthors;
    }

    @Override
    public String Publish() {

        return "<xml>\n" +
                "\t<title>" + this.getName() + "</title>\n" +
                "\t<subtitle>" + this.getSubtitle() + "</subtitle>\n" +
                "\t<isbn>" + this.getISBN() +"</isbn>\n" +
                "\t<pageCount>" + this.getPageCount() + "</pageCount>\n" +
                "\t<keywords>" + this.getKeywords() + "</keywords>\n" +
                "\t<languageID>" + this.getLanguageID() + "</languageID>\n" +
                "\t<createdOn>" + this.getCreatedOn() + "</createdOn>\n" +
                "\t<authors>" + this.getListOfAuthors() + "</authors>\n" +
                "</xml>";
    }

    public static String bookInformation(Book book){

        return "\t\t<book>\n" +
                "\t\t\t<title>" + book.getName() + "</title>\n" +
                "\t\t\t<subtitle>" + book.getSubtitle() + "</subtitle>\n" +
                "\t\t\t<isbn>" + book.getISBN() +"</isbn>\n" +
                "\t\t\t<pageCount>" + book.getPageCount() + "</pageCount>\n" +
                "\t\t\t<keywords>" + book.getKeywords() + "</keywords>\n" +
                "\t\t\t<languageID>" + book.getLanguageID() + "</languageID>\n" +
                "\t\t\t<createdOn>" + book.getCreatedOn() + "</createdOn>\n" +
                "\t\t\t<authors>" + book.getListOfAuthors() + "</authors>\n" +
                "\t\t</book>\n";
    }
}
