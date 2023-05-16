package sr;

import interfase.Invoker;
import interfase.ReceiverServer;
import sr.Commands.CommandManagerServer;
import sr.Parser.CSVParser;
import sr.read.SQL;
import sr.read.write;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ServerCity{
    public static void main(String[]args) throws RuntimeException, IOException, ParseException, ClassNotFoundException, SQLException {
        SQL.SQL();
        ReceiverServer receiverServer =new ReceiverServer(new Invoker());
        receiverServer.creationTree();
        CSVParser.Reader(args);
        CommandManagerServer.start();
        write.s();
        ReceiverServer.Save();

    }
}