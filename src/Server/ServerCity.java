package Server;

import Common.Serialized.Seriobject;
import Common.Serialized.Seritwo;
import Server.Commands.InvokerServer;
import Server.Commands.ReceiverServer;
import Server.Parser.CSVParser;
import Common.Serialized.Seri;
import client.write.write;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;

public class ServerCity{
    static ServerSocket s;
    static Socket ss;
    public static void main(String[]args) throws RuntimeException, IOException, ParseException, ClassNotFoundException {
        CSVParser csvparser = new CSVParser(args);
        ReceiverServer.creationTree();
        csvparser.Reader(args);


        InvokerServer invoker = new InvokerServer();
        write write = new write();
        write.s();
        ServerSocket s =new ServerSocket(9998);
        ss = s.accept();
        //DataOutputStream douts = client.write.gets();
        System.out.println("connection");


        while (true){

            System.out.println(ss);
            ObjectInputStream in = new ObjectInputStream(ss.getInputStream());
            Object o =  in.readObject();
            System.out.println(o);
            if (o instanceof Seri) {
                Seri h= (Seri) o;
                System.out.println(h.getCommand());

                String[] b = new String[1];
                h.getCommand().execute(b);
            } else if (o instanceof Seritwo) {
                Seritwo h = (Seritwo) o;
                System.out.println(h.getCommand());

                String[] b = new String[2];
                b[1]= String.valueOf(h.getKey());
                h.getCommand().execute(b);
            } else if (o instanceof Seriobject) {
                Seriobject h = (Seriobject) o;
                System.out.println(h.getCommand());

                String[] b = new String[2];
                b[1]= String.valueOf(h.getStandard());
                h.getCommand().execute(b);
            }
            //Read g = new Read();
            //g.read(o);



            if (o.equals("exit")){
                break;
            }
        }
    }
    public static Socket getss(){
        return ss;
    }
    public void write(String messege) throws IOException {
        ServerSocket s =new ServerSocket(9998);
        Socket ss = s.accept();
        DataOutputStream douts = new DataOutputStream(ss.getOutputStream());
        douts.writeUTF(messege);
    }
}