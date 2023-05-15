package interfase;

//import client.src.main.java.Commands.write


import java.util.Scanner;

/**
 * Class for reading the elements of a new collection
 */
public class Reader {
    /**
     * Method for reading the elements of a new collection
     *
     * @param message message
     * @return line
     */
    public static String read(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine().trim();
    }
}