package com.netflix;

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
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
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
        commandLine.execute(args);
    }
}
