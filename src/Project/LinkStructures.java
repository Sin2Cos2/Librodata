package Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class LinkStructures {

    /**
     * Read from file with path "src/init/books-authors.in"
     * Static method that insert Author with idAuthor in arrayList of Authors inside of object Book with idBook
     *
     * @param books   Arraylist for searching books with corresponding ID
     * @param authors ArrayList for searching authors with corresponding ID
     */
    public static void linkBookAuthor(ArrayList<Book> books, ArrayList<Author> authors) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/books-authors.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int idBook = Integer.parseInt(splitLine[0]);
                int idAuthor = Integer.parseInt(splitLine[1]);

                Book book = null;
                Author author = null;
                for (Book b : books) {
                    if (b.getID() == idBook) {
                        book = b;
                        break;
                    }
                }
                for (Author a : authors) {
                    if (a.getID() == idAuthor) {
                        author = a;
                        break;
                    }
                }

                if (book != null)
                    book.addAuthor(author);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from file with path "src/init/editorial-groups-books.in"
     * Static method that insert Books with bookID in arrayList of Books inside of object editorialGroup with groupID
     *
     * @param books           Arraylist for searching books with corresponding ID
     * @param editorialGroups ArrayList for searching editorialGroup with corresponding ID
     */
    public static void linkBookEditorialGroup(ArrayList<Book> books, ArrayList<EditorialGroup> editorialGroups) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/editorial-groups-books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int groupID = Integer.parseInt(splitLine[0]);
                int bookID = Integer.parseInt(splitLine[1]);

                EditorialGroup editorialGroup = null;
                Book book = null;
                for (EditorialGroup eG : editorialGroups) {
                    if (eG.getID() == groupID) {
                        editorialGroup = eG;
                        break;
                    }
                }
                for (Book b : books) {
                    if (b.getID() == bookID) {
                        book = b;
                        break;
                    }
                }

                if (editorialGroup != null)
                    editorialGroup.addBook(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from file with path "src/init/publishing-brands-books.in"
     * Static method that insert Books with bookID in arrayList of Books inside of object publishingBrand with publisherID
     *
     * @param books         Arraylist for searching books with corresponding ID
     * @param publishBrands ArrayList for searching publishingBrand with corresponding ID
     */
    public static void linkBookPublishingBrand(ArrayList<Book> books, ArrayList<PublishBrand> publishBrands) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-brands-books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int bookID = Integer.parseInt(splitLine[1]);

                PublishBrand publishBrand = null;
                Book book = null;
                for (PublishBrand pB : publishBrands) {
                    if (pB.getID() == publisherID) {
                        publishBrand = pB;
                        break;
                    }
                }
                for (Book b : books) {
                    if (b.getID() == bookID) {
                        book = b;
                        break;
                    }
                }

                if (publishBrand != null)
                    publishBrand.addBook(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from file with path "src/init/publishing-retailers-books.in"
     * Static method that insert Books with bookID in arrayList of IPublishingArtifacts
     * inside of object publishingRetailer with publisherID
     *
     * @param books               Arraylist for searching books with corresponding ID
     * @param publishingRetailers ArrayList for searching publishingRetailer with corresponding ID
     */
    public static void linkBookPublishingRetailer(ArrayList<Book> books, ArrayList<PublishingRetailer> publishingRetailers) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-retailers-books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int bookID = Integer.parseInt(splitLine[1]);

                PublishingRetailer publishingRetailer = null;
                Book book = null;
                for (PublishingRetailer pR : publishingRetailers) {
                    if (pR.getID() == publisherID) {
                        publishingRetailer = pR;
                        break;
                    }
                }
                for (Book b : books) {
                    if (b.getID() == bookID) {
                        book = b;
                        break;
                    }
                }

                if (publishingRetailer != null)
                    publishingRetailer.addPublishingArtifact(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from file with path "src/init/publishing-retailers-editorial-groups.in"
     * Static method that insert editorialGroups with editorialGroupID in arrayList of IPublishingArtifacts
     * inside of object publishingRetailer with publisherID
     *
     * @param editorialGroups     Arraylist for searching editorialGroups with corresponding ID
     * @param publishingRetailers ArrayList for searching publishingRetailer with corresponding ID
     */
    public static void linkEditorialGroupsPublishingRetailer(ArrayList<EditorialGroup> editorialGroups,
                                                             ArrayList<PublishingRetailer> publishingRetailers) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-retailers-editorial-groups.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int editorialGroupID = Integer.parseInt(splitLine[1]);

                PublishingRetailer publishingRetailer = null;
                EditorialGroup editorialGroup = null;
                for (PublishingRetailer pR : publishingRetailers) {
                    if (pR.getID() == publisherID) {
                        publishingRetailer = pR;
                        break;
                    }
                }
                for (EditorialGroup eG : editorialGroups) {
                    if (eG.getID() == editorialGroupID) {
                        editorialGroup = eG;
                        break;
                    }
                }

                if (publishingRetailer != null)
                    publishingRetailer.addPublishingArtifact(editorialGroup);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from file with path "src/init/publishing-retailers-publishing-brands.in"
     * Static method that insert publishingBrands with editorialGroupID in arrayList of IPublishingArtifacts
     * inside of object publishingRetailer with publisherID
     *
     * @param publishBrands       Arraylist for searching publishingBrands with corresponding ID
     * @param publishingRetailers ArrayList for searching publishingRetailer with corresponding ID
     */
    public static void linkPublishingAuthorsPublishingRetailer(ArrayList<PublishBrand> publishBrands,
                                                               ArrayList<PublishingRetailer> publishingRetailers) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-retailers-publishing-brands.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int publishingBrandID = Integer.parseInt(splitLine[1]);

                PublishingRetailer publishingRetailer = null;
                PublishBrand publishBrand = null;
                for (PublishingRetailer pR : publishingRetailers) {
                    if (pR.getID() == publisherID) {
                        publishingRetailer = pR;
                        break;
                    }
                }
                for (PublishBrand pB : publishBrands) {
                    if (pB.getID() == publishingBrandID) {
                        publishBrand = pB;
                        break;
                    }
                }

                if (publishingRetailer != null)
                    publishingRetailer.addPublishingArtifact(publishBrand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from file with path "src/init/publishing-retailers-countries.in"
     * Static method that insert countries with countryID in arrayList of Countries
     * inside of object publishingRetailer with publisherID
     *
     * @param countries     Arraylist for searching countries with corresponding ID
     * @param publishingRetailers ArrayList for searching publishingRetailer with corresponding ID
     */
    public static void linkCountriesPublishingRetailer(ArrayList<Country> countries, ArrayList<PublishingRetailer> publishingRetailers) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/init/publishing-retailers-countries.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split("###");
                int publisherID = Integer.parseInt(splitLine[0]);
                int countryID = Integer.parseInt(splitLine[1]);

                PublishingRetailer publishingRetailer = null;
                Country country = null;
                for (PublishingRetailer pR : publishingRetailers) {
                    if (pR.getID() == publisherID) {
                        publishingRetailer = pR;
                        break;
                    }
                }
                for (Country c : countries) {
                    if (c.getID() == countryID) {
                        country = c;
                        break;
                    }
                }

                if (publishingRetailer != null)
                    publishingRetailer.addCountry(country);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
