package InputTest;

import Project.Administration;
import Project.Book;
import Project.Country;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class getCountriesForBookID_TEST {

    public static void test(Administration administration,String path, int bookID){
        ArrayList<Country> countries = administration.getCountriesForBookID(bookID);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write("Total countries: " + countries.size() + "\n");
            for(Country country : countries)
                bw.write(country.getCountryCode() + " " + country.getID() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
