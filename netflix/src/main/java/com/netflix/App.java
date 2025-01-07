package com.netflix;

import picocli.CommandLine;

/*
  Main class for Netflix Movie CLI
*/
public class App {

    public static void main(String[] args) {

        System.out.println(
                "\n ─▄▀─▄▀ Netflix Movie CLI\n" +
                        " ──▀──▀\n" +
                        " █▀▀▀▀▀█▄\n" +
                        " █░░░░░█─█\n" +
                        " ▀▄▄▄▄▄▀▀\n");

        CommandLine commandLine = new CommandLine(new CLI());
        commandLine.execute(args);
    }

}
