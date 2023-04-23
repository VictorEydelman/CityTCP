package Server.read;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;

public class write {
    static ServerSocket s;
    static Socket ss;
    public static void s() throws IOException, ClassNotFoundException, ParseException {
        s =new ServerSocket(9998);
        ss = s.accept();
        while (true){
            ObjectInputStream in = new ObjectInputStream(ss.getInputStream());
            new ObjectToSerialized(in.readObject());
        }
    }
    public static Socket getss(){
        return ss;
    }
}
