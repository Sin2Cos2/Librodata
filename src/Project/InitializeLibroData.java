package Project;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class InitializeLibroData {

    public InitializeLibroData() {
    }

    /**
     * Open a file with path "src/init/books.in" with a BufferReader
     * Read file line by line and initialize an instance of Book on each iteration
     * String date is parsed to Calendar with SimpleDateFormat
     * At the end, all the books are stocked in arrayList
     *
     * @return ArrayList of initialized books
     */
    public static ArrayList<Book> initializeBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int ID = Integer.parseInt(splitLine[0]);
                String name = splitLine[1];
                String subtitle = splitLine[2];
                String ISBN = splitLine[3];
                int pageCount = Integer.parseInt(splitLine[4]);
                String Keywords = splitLine[5];
                int LanguageID = Integer.parseInt(splitLine[6]);

                Calendar createdOn = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                createdOn.setTime(dateFormat.parse(splitLine[7]));

                Book book = new Book(ID, name, subtitle, ISBN, pageCount, Keywords, LanguageID, createdOn);
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return books;
    }

    /**
     * Open a file("src/init/languages.in") with a BufferReader
     * Read file line by line and initialize an instance of Language class
     * All the languages are stocked in ArrayList languages
     *
     * @return ArrayList of Languages
     */
    public static ArrayList<Language> initializeLanguages() {
        ArrayList<Language> languages = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/languages.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int ID = Integer.parseInt(splitLine[0]);
                String code = splitLine[1];
                String translation = splitLine[2];

                Language language = new Language(ID, code, translation);
                languages.add(language);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return languages;
    }

    /**
     * Open a file("src/init/authors.in") with a BufferReader
     * Read file line by line and initialize an instance of Author class
     * All the authors are stocked in ArrayList authors
     *
     * @return ArrayList of authors
     */
    public static ArrayList<Author> initializeAuthors() {
        ArrayList<Author> authors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/authors.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int ID = Integer.parseInt(splitLine[0]);
                String firstName = splitLine[1];
                String lastName = splitLine[2];

                Author author = new Author(ID, firstName, lastName);
                authors.add(author);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authors;
    }

    /**
     * A generic method that can initialize 4 structures of the following types:
     * country, editorialGroup, publishingBrand, publishingRetailer
     *
     * @param path to the file from which information will be read
     * @param type of objects which will be initialized
     * @return arrayList with objects of passed type
     */
    public static <T> ArrayList<T> initializeStructure(String path, String type) {
        ArrayList<T> structure = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                Integer ID = Integer.parseInt(splitLine[0]);
                T temp;
                switch (type) {
                    case "country" -> temp = (T) new Country(ID, splitLine[1]);
                    case "editorialGroup" -> temp = (T) new EditorialGroup(ID, splitLine[1]);
                    case "publishingBrand" -> temp = (T) new PublishBrand(ID, splitLine[1]);
                    case "publishingRetailer" -> temp = (T) new PublishingRetailer(ID, splitLine[1]);
                    default -> temp = null;
                }

                structure.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return structure;
    }
}
