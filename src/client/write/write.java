package client.write;

import java.io.DataOutputStream;
import java.io.IOException;

//mport static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

//import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

//import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

public class write {
    //Socket ss=Server.getS()
    public void write(String messege) throws IOException {

      //  Socket ss = Server.;
        //DataOutputStream douts = new DataOutputStream(ss.getOutputStream());
        //douts.writeUTF(messege);
    }
    static DataOutputStream douts;
    public static void s() throws IOException {
        //ServerSocket s =new ServerSocket(9998);
        //Socket ss = s.accept();
        //DataOutputStream douts = new DataOutputStream(ss.getOutputStream());
    }
    public static DataOutputStream gets() throws IOException{
        return douts;
    }
}
