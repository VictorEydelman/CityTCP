package sr;

import interfase.Invoker;
import sr.Commands.CommandManagerServer;
import sr.Commands.ReceiverServer;
import sr.Parser.CSVParser;
import sr.read.write;

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