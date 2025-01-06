package com.netflix;
import java.util.concurrent.Callable;

import picocli.CommandLine;

@CommandLine.Command(name = "netflix-cli", mixinStandardHelpOptions = true, description = "Netflix CLI to manage movies")
public class CLI implements Callable<Integer> {
    
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Display help message")
    boolean helpRequested;

    @CommandLine.Option(names = {"-l", "--list"}, description = "List all movies")
    void start(@CommandLine.Parameters(paramLabel = "list", description = "List all movies") String list) {
        System.out.println("Listing all movies");
    }


    @Override
    public Integer call() throws Exception {
        System.err.println(" Use 'netflix-cli --help' for usage.");
        return 1;
    }
    
}