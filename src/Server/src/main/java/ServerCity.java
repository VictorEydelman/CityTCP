package Server.src.main.java;

import Common.src.main.java.interfase.Invoker;
import Server.Commands.CommandManagerServer;
import Server.src.main.java.Commands.ReceiverServer;
import Server.src.main.java.Parser.CSVParser;
import Server.src.main.java.read.write;

import java.io.IOException;
import java.text.ParseException;

public class ServerCity{
    public static void main(String[]args) throws RuntimeException, IOException, ParseException, ClassNotFoundException {
        ReceiverServer receiverServer =new ReceiverServer(new Invoker());
        receiverServer.creationTree();
        CSVParser.Reader(args);
        CommandManagerServer.start();
        write.s();
        ReceiverServer.Save();
    }
}