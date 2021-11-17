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

    /**
     * Initialize and link all the structures
     */
    public Administration() {
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

    /**
     * Browsing the publishingArtifacts arrayList, looking for all the books, inclusive books from arrayLists inside
     * editorialGroups and publishingBrands, if books is not in arrayList yet, adding it to the end of array
     *
     * @param publishingRetailerID - valid ID to find corresponding publishingRetailer in arrayList of publishingRetailers
     * @return ArrayList of Books from publishingRetailer with ID == publishingRetailedID
     */
    public ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID) {
        ArrayList<Book> books = new ArrayList<>();
        PublishingRetailer publishingRetailer = null;
        for (PublishingRetailer pR : this.publishingRetailers) {
            if (pR.getID() == publishingRetailerID) {
                publishingRetailer = pR;
                break;
            }
        }

        if (publishingRetailer == null)
            return books;
        for (IPublishingArtifact pA : publishingRetailer.getPublishingArtifacts()) {
            if (pA instanceof Book book) {
                if (!books.contains(book)) {
                    books.add(book);
                }
            }
            if (pA instanceof EditorialGroup editorialGroup) {
                for (Book book : editorialGroup.getBooks()) {
                    if (!books.contains(book)) {
                        books.add(book);
                    }
                }
            }
            if (pA instanceof PublishBrand publishBrand) {
                for (Book book : publishBrand.getBooks()) {
                    if (!books.contains(book)) {
                        books.add(book);
                    }
                }
            }
        }


        return books;
    }

    /**
     * Browsing the publishingArtifacts arrayList, looking for all the books, inclusive books from arrayLists inside
     * editorialGroups and publishingBrands, looking for languageID of each Book in this.languages arrayList and adding
     * to the end of the arrayList which will be returned
     *
     * @param publishingRetailerID - valid ID to find corresponding publishingRetailer in arrayList of publishingRetailers
     * @return ArrayList of Languages from publishingRetailer with ID == publishingRetailedID
     */
    public ArrayList<Language> getLanguageForPublishingRetailerID(int publishingRetailerID) {
        ArrayList<Language> languages = new ArrayList<>();
        PublishingRetailer publishingRetailer = null;
        TreeSet<Integer> languageID = new TreeSet();

        for (PublishingRetailer pR : this.publishingRetailers) {
            if (pR.getID() == publishingRetailerID) {
                publishingRetailer = pR;
                break;
            }
        }

        if (publishingRetailer == null)
            return languages;
        for (IPublishingArtifact pA : publishingRetailer.getPublishingArtifacts()) {
            if (pA instanceof Book book)
                languageID.add(book.getLanguageID());
            if (pA instanceof EditorialGroup editorialGroup) {
                for (Book book : editorialGroup.getBooks())
                    languageID.add(book.getLanguageID());
            }
            if (pA instanceof PublishBrand publishBrand) {
                for (Book book : publishBrand.getBooks()) {
                    languageID.add(book.getLanguageID());
                }
            }
        }

        for (Integer langID : languageID) {
            for (Language language : this.languages) {
                if (language.getID() == langID) {
                    languages.add(language);
                    break;
                }
            }
        }
        return languages;
    }

    private boolean checkBook(IPublishingArtifact publishingArtifact, int bookID) {
        if (publishingArtifact instanceof Book book) {
            if (book.getID() == bookID)
                return true;
        }
        if (publishingArtifact instanceof PublishBrand publishBrand) {
            for (Book book : publishBrand.getBooks())
                if (book.getID() == bookID)
                    return true;
        }
        if (publishingArtifact instanceof EditorialGroup editorialGroup) {
            for (Book book : editorialGroup.getBooks())
                if (book.getID() == bookID)
                    return true;
        }
        return false;
    }

    /**
     * Browsing each publishingRetailer, if publishingArtifact arrayList contains Book with ID == bookID, method
     * checkBook return true, in this case all the countries from publishingRetailer.countries will be added to countries
     * arrayList, which will be returned
     *
     * @param bookID valid ID to find corresponding Book in publishingRetailers
     * @return Arraylist of countries
     */
    public ArrayList<Country> getCountriesForBookID(int bookID) {
        ArrayList<Country> countries = new ArrayList<>();

        for (PublishingRetailer pR : this.publishingRetailers) {
            for (IPublishingArtifact pA : pR.getPublishingArtifacts()) {
                if (checkBook(pA, bookID)) {
                    for (Country c : pR.getCountries()) {
                        if (!countries.contains(c))
                            countries.add(c);
                    }
                    break;
                }
            }
        }

        return countries;
    }

    /**
     * Obtaining two arrayList, adding first to the HashSet
     * Browsing the second arrayList, if HashSet contains books, adding to the arrayList which will be returned
     * Complexity: O(n + m)
     *
     * @param retailerID1 Valid ID of the first retailer
     * @param retailerID2 Valid ID of the second retailer
     * @return ArrayList of common books between retailer with ID == retailerID1 and retailer with ID == retailerID2
     */
    public ArrayList<Book> getCommonBooksForRetailersIDs(int retailerID1, int retailerID2) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> booksRetailerID1 = getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> booksRetailerID2 = getBooksForPublishingRetailerID(retailerID2);
        HashSet<Book> commonBooks = new HashSet<>();

        for (Book book : booksRetailerID1)      //O(n)
            commonBooks.add(book);              //O(1)
        for (Book book : booksRetailerID2) {    //O(m)
            if (commonBooks.contains(book))     //O(1)
                books.add(book);                //O(1)
        }

        return books;
    }

    /**
     * Obtaining two arrayList, adding both arrays to the HashSet
     * Converting HashSet to the arrayList
     * Complexity: O(n + m)
     *
     * @param retailerID1 Valid ID of the first retailer
     * @param retailerID2 Valid ID of the second retailer
     * @return ArrayList of common books between retailer with ID == retailerID1 and retailer with ID == retailerID2
     */
    public ArrayList<Book> getAllBooksForRetailersIDs(int retailerID1, int retailerID2) {
        ArrayList<Book> books;
        ArrayList<Book> booksRetailerID1 = getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> booksRetailerID2 = getBooksForPublishingRetailerID(retailerID2);
        HashSet<Book> allBooks = new HashSet<>();

        for (Book book : booksRetailerID1)  //O(n)
            allBooks.add(book);             //O(1)
        for (Book book : booksRetailerID2)  //O(m)
            allBooks.add(book);             //O(1)

        books = new ArrayList<>(allBooks);  //O(1)

        return books;
    }
}
