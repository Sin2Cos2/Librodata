package Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Administration {

    private ArrayList<Book> books;
    private ArrayList<Author> authors;
    private ArrayList<Language> languages;
    private ArrayList<Country> countries;
    private ArrayList<EditorialGroup> editorialGroups;
    private ArrayList<PublishBrand> publishBrands;
    private ArrayList<PublishingRetailer> publishingRetailers;

    public Administration(){
        setBooks(InitializeLibroData.initializeBooks());
        setAuthors(InitializeLibroData.initializeAuthors());
        setLanguages(InitializeLibroData.initializeLanguages());
        setCountries(InitializeLibroData.initializeStructure("src/init/countries.in", "country"));
        setEditorialGroups(InitializeLibroData.initializeStructure
                ("src/init/editorial-groups.in", "editorialGroup"));
        setPublishBrands(InitializeLibroData.initializeStructure
                ("src/init/publishing-brands.in", "publishingBrand"));
        setPublishingRetailers(InitializeLibroData.initializeStructure
                ("src/init/publishing-retailers.in", "publishingRetailer"));

        LinkStructures.linkBookAuthor(books, authors);
        LinkStructures.linkBookEditorialGroup(books, editorialGroups);
        LinkStructures.linkBookPublishingBrand(books, publishBrands);
        LinkStructures.linkBookPublishingRetailer(books, publishingRetailers);
        LinkStructures.linkCountriesPublishingRetailer(countries, publishingRetailers);
        LinkStructures.linkEditorialGroupsPublishingRetailer(editorialGroups, publishingRetailers);
        LinkStructures.linkPublishingAuthorsPublishingRetailer(publishBrands, publishingRetailers);
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    public void setEditorialGroups(ArrayList<EditorialGroup> editorialGroups) {
        this.editorialGroups = editorialGroups;
    }

    public void setPublishBrands(ArrayList<PublishBrand> publishBrands) {
        this.publishBrands = publishBrands;
    }

    public void setPublishingRetailers(ArrayList<PublishingRetailer> publishingRetailers) {
        this.publishingRetailers = publishingRetailers;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public ArrayList<EditorialGroup> getEditorialGroups() {
        return editorialGroups;
    }

    public ArrayList<PublishBrand> getPublishBrands() {
        return publishBrands;
    }

    public ArrayList<PublishingRetailer> getPublishingRetailers() {
        return publishingRetailers;
    }

    public ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID){
        ArrayList<Book> books = new ArrayList<>();
        PublishingRetailer publishingRetailer = null;
        for(PublishingRetailer pR : this.publishingRetailers){
            if(pR.getID() == publishingRetailerID){
                publishingRetailer = pR;
                break;
            }
        }

        if(publishingRetailer == null)
            return books;
        for(IPublishingArtifact pA : publishingRetailer.getPublishingArtifacts()){
            if(pA instanceof Book book){
                if(!books.contains(book)){
                    books.add(book);
                }
            }
            if(pA instanceof EditorialGroup editorialGroup){
                for(Book book : editorialGroup.getBooks()){
                    if(!books.contains(book)){
                        books.add(book);
                    }
                }
            }
            if(pA instanceof PublishBrand publishBrand){
                for(Book book : publishBrand.getBooks()){
                    if(!books.contains(book)){
                        books.add(book);
                    }
                }
            }
        }


        return books;
    }

    public ArrayList<Language> getLanguageForPublishingRetailerID(int publishingRetailerID){
        ArrayList<Language> languages = new ArrayList<>();
        PublishingRetailer publishingRetailer = null;
        TreeSet<Integer> languageID = new TreeSet();

        for(PublishingRetailer pR : this.publishingRetailers) {
            if (pR.getID() == publishingRetailerID) {
                publishingRetailer = pR;
                break;
            }
        }

        if(publishingRetailer == null)
            return languages;
        for(IPublishingArtifact pA : publishingRetailer.getPublishingArtifacts()){
            if(pA instanceof Book book)
                languageID.add(book.getLanguageID());
            if(pA instanceof EditorialGroup editorialGroup){
                for(Book book : editorialGroup.getBooks())
                    languageID.add(book.getLanguageID());
            }
            if(pA instanceof PublishBrand publishBrand){
                for(Book book : publishBrand.getBooks()){
                    languageID.add(book.getLanguageID());
                }
            }
        }

        for(Integer langID : languageID){
            for(Language language : this.languages){
                if(language.getID() == langID){
                    languages.add(language);
                    break;
                }
            }
        }
        return languages;
    }

    private boolean checkBook(IPublishingArtifact publishingArtifact, int bookID){
        if(publishingArtifact instanceof Book book){
            if(book.getID() == bookID)
                return true;
        }
        if(publishingArtifact instanceof PublishBrand publishBrand){
            for(Book book : publishBrand.getBooks())
                if (book.getID() == bookID)
                    return true;
        }
        if(publishingArtifact instanceof EditorialGroup editorialGroup){
            for(Book book : editorialGroup.getBooks())
                if(book.getID() == bookID)
                    return true;
        }
        return false;
    }

    public ArrayList<Country> getCountriesForBookID(int bookID){
        ArrayList<Country> countries = new ArrayList<>();

        for(PublishingRetailer pR : this.publishingRetailers){
            for(IPublishingArtifact pA : pR.getPublishingArtifacts()){
                if(checkBook(pA, bookID)){
                    for(Country c : pR.getCountries()){
                        if(!countries.contains(c))
                            countries.add(c);
                    }
                    break;
                }
            }
        }

        return countries;
    }

    public ArrayList<Book> getCommonBooksForRetailersIDs(int retailerID1, int retailerID2){
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> booksRetailerID1 = getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> booksRetailerID2 = getBooksForPublishingRetailerID(retailerID2);
        HashSet<Book> commonBooks = new HashSet<>();

        for(Book book : booksRetailerID1)
            commonBooks.add(book);
        for(Book book : booksRetailerID2){
            if(commonBooks.contains(book))
                books.add(book);
        }

        return books;
    }

    public ArrayList<Book> getAllBooksForRetailersIDs(int retailerID1, int retailerID2){
        ArrayList<Book> books;
        ArrayList<Book> booksRetailerID1 = getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> booksRetailerID2 = getBooksForPublishingRetailerID(retailerID2);
        HashSet<Book> allBooks = new HashSet<>();

        for(Book book : booksRetailerID1)
            allBooks.add(book);
        for(Book book : booksRetailerID2)
            allBooks.add(book);

        books = new ArrayList<>(allBooks);

        return books;
    }

    public static void main(String[] args) {
        Administration administration = new Administration();
        for(EditorialGroup editorialGroup : administration.editorialGroups)
            System.out.println("ID: " + editorialGroup.getID() + " numOfBooks: " + editorialGroup.getBooks().size());
        ArrayList<Book> books = administration.getBooksForPublishingRetailerID(10);
        ArrayList<Language> languages = administration.getLanguageForPublishingRetailerID(24);
        ArrayList<Country> countries = administration.getCountriesForBookID(262);
        ArrayList<Book> commonBooks = administration.getCommonBooksForRetailersIDs(20, 22);
        ArrayList<Book> unionOfBooks = administration.getAllBooksForRetailersIDs(3,2);
    }
}
