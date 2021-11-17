# Librodata - Gestiunea si livrarea de carti electronice

### Rusu Dionisie 324CB

### Description

This project is created to manage a simplified version of an online book store

Program's possibilities:

* Create a database, reading information from the given files
* Set up connections between data alsa using files
* Find books, countries and languages by given retailer or book ID
* Find common books for two retailers
* Find all books from two retailers

***

### Functionality

Main class is named Administration. At the moment, when we initialize an instance of Administration, all of 7 structures
are initialized and linked from the files.

```Java
class Program {
    /**
     * All the structure are initialized and linked in constructor
     */
    Administration administration = new Administration();
}
```

#### 5 methods for searching

* getBooksForPublishingRetailerID

```Java
class Program {
    /**
     * Browsing the publishingArtifacts arrayList, looking for all the books, inclusive books from arrayLists inside
     * editorialGroups and publishingBrands, if books is not in arrayList yet, adding it to the end of array
     *
     * @param publishingRetailerID - valid ID to find corresponding publishingRetailer in arrayList of publishingRetailers
     * @return ArrayList of Books from publishingRetailer with ID == publishingRetailedID
     */
    Book[] books = getBooksForPublishingRetailerID(retailedID);
}
```

* getLanguageForPublishingRetailerID

```Java
class Program {
    /**
     * Browsing the publishingArtifacts arrayList, looking for all the books, inclusive books from arrayLists inside
     * editorialGroups and publishingBrands, looking for languageID of each Book in this.languages arrayList and adding
     * to the end of the arrayList which will be returned
     *
     * @param publishingRetailerID - valid ID to find corresponding publishingRetailer in arrayList of publishingRetailers
     * @return ArrayList of Languages from publishingRetailer with ID == publishingRetailedID
     */
    Language[] languages = getLanguageForPublishingRetailerID(retailerID);
}
```

* getCountriesForBookID

```Java
class Program {
    /**
     * Browsing each publishingRetailer, if publishingArtifact arrayList contains Book with ID == bookID, method
     * checkBook return true, in this case all the countries from publishingRetailer.countries will be added to countries
     * arrayList, which will be returned
     *
     * @param bookID valid ID to find corresponding Book in publishingRetailers
     * @return Arraylist of countries
     */
    Contry[] countries = getCountriesForBookID(bookID);
}
```

* getCommonBooksForRetailersIDs

```Java
class Program {
    /**
     * Obtaining two arrayList, adding first to the HashSet
     * Browsing the second arrayList, if HashSet contains books, adding to the arrayList which will be returned
     * Complexity: O(n + m)
     *
     * @param retailerID1 Valid ID of the first retailer
     * @param retailerID2 Valid ID of the second retailer
     * @return ArrayList of common books between retailer with ID == retailerID1 and retailer with ID == retailerID2
     */
    Book[] books = getCommonBooksForRetailersIDs(retailerID1, retailerID2);
}
```

* getAllBooksForRetailersIDs

```Java
class Program {
    /**
     * Obtaining two arrayList, adding both arrays to the HashSet
     * Converting HashSet to the arrayList
     * Complexity: O(n + m)
     *
     * @param retailerID1 Valid ID of the first retailer
     * @param retailerID2 Valid ID of the second retailer
     * @return ArrayList of common books between retailer with ID == retailerID1 and retailer with ID == retailerID2
     */
    Book[] books = getAllBooksForRetailersIDs(retailerID1, retailerID2);
}
```

***

## Project structure

* Book contains the array of authors. Implements IPublishingArtifact interface
* EditorialGroup contains the array of books. Implements IPublishingArtifact interface
* PublishingBrand contains the array of books. Implements IPublishingArtifact interface
* PublishingRetailer contains array of classes that implements IPublishingArtifact and array of countries

> Book.authors <= author

> EditorialGroup.books <= book

> PublishingBrand.books <= book

> PublishingRetailer.publishingArtifacts <= Book, EditorialGroup, PublishingBrand

> PublishingRetailer.countries <= Country
***

## Class description

* Administration

> Implements 5 searching methods

* Author, Book, Country, Language, PublishingBrand, EditorialGroup

> Classes that model their specific entity

* IPublishingArtifact

> Implement the method Publish() that return information in XML format

* InitializeLibroData

> Initialize all the 7 arrayLists from the input files

* LinkStructures

> Link structures
***

## Tests

### All the test inputs are in src/InputTest

* All tests are run from the main class main_TEST

### All the test outputs are in src/OutputTest


