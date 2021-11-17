package Project;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class InitializeLibroData {

    public InitializeLibroData() {
    }

    public static ArrayList<Book> initializeBooks(){
        ArrayList<Book> books = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/books.in"))) {
            String line = br.readLine();
            while((line = br.readLine()) != null){
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

    public static ArrayList<Language> initializeLanguages(){
        ArrayList<Language> languages = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/languages.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null){
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

    public static ArrayList<Author> initializeAuthors(){
        ArrayList<Author> authors = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/authors.in"))){
            String line = br.readLine();
            while((line = br.readLine()) != null){
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

    public static <T> ArrayList<T> initializeStructure(String path, String type){
        ArrayList<T> structure = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while ((line = br.readLine()) != null){
                String[] splitLine = line.split("###");
                Integer ID = Integer.parseInt(splitLine[0]);
                T temp;
                switch (type){
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
