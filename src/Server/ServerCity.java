package Server;

import Common.Invoker;
import Server.Commands.CommandManagerServer;
import Server.Commands.ReceiverServer;
import Server.Parser.CSVParser;
import Server.read.write;

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