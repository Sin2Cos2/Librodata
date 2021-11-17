package InputTest;

import Project.Administration;
import Project.Book;
import Project.Language;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class getLanguageForPublishingRetailerID_TEST {

    public static void test(Administration administration, String path, int retailerID){
        ArrayList<Language> languages = administration.getLanguageForPublishingRetailerID(retailerID);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write("Total languages: " + languages.size() + "\n");
            for(Language language : languages)
                bw.write(language.getName() + " " + language.getID() + " " + language.getCode() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
