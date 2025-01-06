package com.netflix;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import picocli.CommandLine;



/*
mvn compile && mvn exec:java -Dexec.mainClass="com.netflix.App"
mvn clean package && java -jar target/netflix-1.0-SNAPSHOT.jar
 */
/**
 * Hello world!
 *
 */
public class App 
{
    private static final String FILE_PATH = "src/main/resources/netflix_titles.csv";

    public static void main( String[] args )
    {
        // show_id,type,title,director,cast,country,date_added,release_year,rating,duration,listed_in,description

        List<String[]> movies = readCsv();
        if (movies == null) {
            System.out.println("Error reading CSV file");
            return;
        }

        if(movies != null) {
            // for (String[] movie : movies) {
                
            // }
            System.out.println("Total movies: " + movies.size()); // movies count
        }



/*
 ─▄▀─▄▀
──▀──▀
█▀▀▀▀▀█▄
█░░░░░█─█
▀▄▄▄▄▄▀▀

 */
        System.out.println(
            "\n ─▄▀─▄▀ Netflix Movie CLI\n" +
            " ──▀──▀\n" +
            " █▀▀▀▀▀█▄\n" +
            " █░░░░░█─█\n" +
            " ▀▄▄▄▄▄▀▀\n"
        );

        CommandLine commandLine = new CommandLine(new CLI());
        // commandLine.execute(args);
    }


    public static List<String[]> readCsv() {
        try (CSVReader reader = new CSVReader(new FileReader(FILE_PATH))) {
            return reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
