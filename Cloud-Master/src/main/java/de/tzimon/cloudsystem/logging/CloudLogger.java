package de.tzimon.cloudsystem.logging;

public class CloudLogger {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
//    public static final String GREEN = "\u001B[32m";
//    public static final String BLACK = "\u001B[30m";
//    public static final String YELLOW = "\u001B[33m";
//    public static final String PURPLE = "\u001B[35m";
//    public static final String CYAN = "\u001B[36m";
//    public static final String WHITE = "\u001B[37m";

    public static void info(String message) {
        logFormatted(message);
    }

    public static void error(String message) {
        logFormatted(RED + message);
    }

    private static void logFormatted(String formattedMessage) {
        System.out.println(BLUE + "CloudSystem " + RESET + "» " + formattedMessage + RESET);
    }

}
