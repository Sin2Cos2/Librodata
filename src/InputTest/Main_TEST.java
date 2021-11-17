package InputTest;

import Project.Administration;

public class Main_TEST {

    public static void main(String[] args) {
        Administration administration = new Administration();

        getBookForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getBookForPublishingRetailerID_TEST1", 13);
        getBookForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getBookForPublishingRetailerID_TEST2", 2);
        getBookForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getBookForPublishingRetailerID_TEST3", 30);
        getBookForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getBookForPublishingRetailerID_TEST4", 22);
        getBookForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getBookForPublishingRetailerID_TEST5", 16);

        getLanguageForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getLanguageForPublishingRetailerID_TEST1", 13);
        getLanguageForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getLanguageForPublishingRetailerID_TEST2", 27);
        getLanguageForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getLanguageForPublishingRetailerID_TEST3", 1);
        getLanguageForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getLanguageForPublishingRetailerID_TEST4", 7);
        getLanguageForPublishingRetailerID_TEST.test
                (administration, "src/OutputTest/getLanguageForPublishingRetailerID_TEST5", 33);

        getCountriesForBookID_TEST.test(administration, "src/OutputTest/getCountriesForBookID_TEST1", 513);
        getCountriesForBookID_TEST.test(administration, "src/OutputTest/getCountriesForBookID_TEST2", 4131);
        getCountriesForBookID_TEST.test(administration, "src/OutputTest/getCountriesForBookID_TEST3", 8064);
        getCountriesForBookID_TEST.test(administration, "src/OutputTest/getCountriesForBookID_TEST4", 14697);
        getCountriesForBookID_TEST.test(administration, "src/OutputTest/getCountriesForBookID_TEST5", 11494);

        getCommonBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getCommonBooksForRetailersIDs_TEST1", 1, 2);
        getCommonBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getCommonBooksForRetailersIDs_TEST2", 7, 14);
        getCommonBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getCommonBooksForRetailersIDs_TEST3", 27, 33);
        getCommonBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getCommonBooksForRetailersIDs_TEST4", 33, 9);
        getCommonBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getCommonBooksForRetailersIDs_TEST5", 11, 29);

        getAllBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getAllBooksForRetailersIDs_TEST1", 13, 25);
        getAllBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getAllBooksForRetailersIDs_TEST2", 1, 17);
        getAllBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getAllBooksForRetailersIDs_TEST3", 22, 32);
        getAllBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getAllBooksForRetailersIDs_TEST4", 10, 4);
        getAllBooksForRetailersIDs_TEST.test
                (administration, "src/OutputTest/getAllBooksForRetailersIDs_TEST5", 28, 3);
    }
}
