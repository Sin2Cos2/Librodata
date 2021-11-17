package Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class LinkStructures {

    public static void linkBookAuthor(ArrayList<Book> books, ArrayList<Author> authors){

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/books-authors.in"))){
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] splitLine = line.split("###");
                int idBook = Integer.parseInt(splitLine[0]);
                int idAuthor = Integer.parseInt(splitLine[1]);

                Book book = null;
                Author author = null;
                for(Book b : books) {
                    if (b.getID() == idBook) {
                        book = b;
                        break;
                    }
                }
                for(Author a : authors) {
                    if (a.getID() == idAuthor) {
                        author = a;
                        break;
                    }
                }

                if(book != null)
                    book.addAuthor(author);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void linkBookEditorialGroup(ArrayList<Book> books, ArrayList<EditorialGroup> editorialGroups){

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/editorial-groups-books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null){
                String[] splitLine = line.split("###");
                int groupID = Integer.parseInt(splitLine[0]);
                int bookID = Integer.parseInt(splitLine[1]);

                EditorialGroup editorialGroup = null;
                Book book = null;
                for(EditorialGroup eG : editorialGroups){
                    if(eG.getID() == groupID){
                        editorialGroup = eG;
                        break;
                    }
                }
                for(Book b : books){
                    if(b.getID() == bookID){
                        book = b;
                        break;
                    }
                }

                if(editorialGroup != null)
                    editorialGroup.addBook(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void linkBookPublishingBrand(ArrayList<Book> books, ArrayList<PublishBrand> publishBrands){

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-brands-books.in"))) {
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int bookID = Integer.parseInt(splitLine[1]);

                PublishBrand publishBrand = null;
                Book book = null;
                for(PublishBrand pB : publishBrands){
                    if(pB.getID() == publisherID){
                        publishBrand = pB;
                        break;
                    }
                }
                for(Book b : books){
                    if(b.getID() == bookID){
                        book = b;
                        break;
                    }
                }

                if(publishBrand != null)
                    publishBrand.addBook(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void linkBookPublishingRetailer(ArrayList<Book> books, ArrayList<PublishingRetailer> publishingRetailers){

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-retailers-books.in"))) {
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int bookID = Integer.parseInt(splitLine[1]);

                PublishingRetailer publishingRetailer = null;
                Book book = null;
                for(PublishingRetailer pR : publishingRetailers){
                    if(pR.getID() == publisherID){
                        publishingRetailer = pR;
                        break;
                    }
                }
                for(Book b : books){
                    if(b.getID() == bookID){
                        book = b;
                        break;
                    }
                }

                if(publishingRetailer != null)
                    publishingRetailer.addPublishingArtifact(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void linkEditorialGroupsPublishingRetailer(ArrayList<EditorialGroup> editorialGroups,
                                                             ArrayList<PublishingRetailer> publishingRetailers){

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-retailers-editorial-groups.in"))) {
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int editorialGroupsID = Integer.parseInt(splitLine[1]);

                PublishingRetailer publishingRetailer = null;
                EditorialGroup editorialGroup = null;
                for(PublishingRetailer pR : publishingRetailers){
                    if(pR.getID() == publisherID){
                        publishingRetailer = pR;
                        break;
                    }
                }
                for(EditorialGroup eG : editorialGroups){
                    if(eG.getID() == editorialGroupsID){
                        editorialGroup = eG;
                        break;
                    }
                }

                if(publishingRetailer != null)
                    publishingRetailer.addPublishingArtifact(editorialGroup);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void linkPublishingAuthorsPublishingRetailer(ArrayList<PublishBrand> publishBrands,
                                                               ArrayList<PublishingRetailer> publishingRetailers){

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-retailers-publishing-brands.in"))) {
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int publishingBrandID = Integer.parseInt(splitLine[1]);

                PublishingRetailer publishingRetailer = null;
                PublishBrand publishBrand = null;
                for(PublishingRetailer pR : publishingRetailers){
                    if(pR.getID() == publisherID){
                        publishingRetailer = pR;
                        break;
                    }
                }
                for(PublishBrand pB : publishBrands){
                    if(pB.getID() == publishingBrandID){
                        publishBrand = pB;
                        break;
                    }
                }

                if(publishingRetailer != null)
                    publishingRetailer.addPublishingArtifact(publishBrand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void linkCountriesPublishingRetailer(ArrayList<Country> countries, ArrayList<PublishingRetailer> publishingRetailers){

        try(BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-retailers-countries.in"))) {
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int countryID = Integer.parseInt(splitLine[1]);

                PublishingRetailer publishingRetailer = null;
                Country country = null;
                for(PublishingRetailer pR : publishingRetailers){
                    if(pR.getID() == publisherID){
                        publishingRetailer = pR;
                        break;
                    }
                }
                for(Country c : countries){
                    if(c.getID() == countryID){
                        country = c;
                        break;
                    }
                }

                if(publishingRetailer != null)
                    publishingRetailer.addCountry(country);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
