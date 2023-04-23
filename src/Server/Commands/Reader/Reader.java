package Server.Commands.Reader;

import client.Commands.Receiver;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class for reading the elements of a new collection
 */
public class Reader {
    /**
     * Method for reading the elements of a new collection
     * @param message message
     * @return line
     */
    public static String read(String message) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        //client.write client.write = new client.write();
        //Socket ss = client.write.s();
        //DataOutputStream douts = new DataOutputStream(ss.getOutputStream());
        //douts.writeUTF(message);
        return scanner.nextLine().trim();
    }

    /**
     * Method for reading the elements of a new collection
     * @param message message
     * @return line
     * @throws IOException mistake
     */
    public static String readExecute(String message) throws IOException {
        Scanner scanner = new Scanner(Receiver.getFile());
        int number = Receiver.getNumberLine();
        for (int i = 0; i < number - 1; i++) {
            scanner.nextLine();
        }
        return scanner.nextLine().trim();
    }
}