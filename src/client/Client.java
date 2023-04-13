package client;


import client.Commands.CommandManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;

public class Client {
    private static SocketChannel socketChannel = null;

    public static void main(String[] args) throws Exception {
        InetSocketAddress s=new InetSocketAddress("localhost",9998);
        String port="9998";
        socketChannel = SocketChannel.open();
        socketChannel.connect(s);
        socketChannel.configureBlocking(false);



        //DataOutputStream dout =new DataOutputStream(s.getOutputStream());
        //DataInputStream douts = new DataInputStream(s.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //dout.writeUTF(port);
        ReadableByteChannel in = Channels.newChannel(System.in);
        byte arr[]={0,1,2,3,4,5,6,7,8,9};
        //ByteBuffer buf=ByteBuffer.wrap(arr);
        //Receiver receiver = new Receiver(new Invoker());
        while (true) {
            CommandManager.start();
            CommandManager.Scan();



            //send.send(new Help(receiver));

            //Thread.sleep(2000);

            /*ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.array());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);*/


            String line = br.readLine();

            if (line.startsWith("exit")) {

                break;
            }
            //buffer.clear();
            //buffer.put(line.getBytes());
            //System.out.println(buffer);
            //buffer.flip();

            /*while (buffer.hasRemaining()) {

                socketChannel.client.write(buffer);
            }*/
        }
        /*while (true){

            //String so = br.readLine();


            in.read(buf);
            buf.flip();
            int n=socketChannel.client.write(buf);
            System.out.println(n+" "+buf);

            //buf.clear();
            int m = socketChannel.read(buf);
            buf.clear();
            System.out.println(m);*/
            //for (byte j: arr){
              //  System.out.println(j);
            //}
            //dout.writeUTF(so);
            //System.out.println(douts.readUTF());
            //if (so.equalsIgnoreCase("exit")){
              //  break;
            //}
        //}
        //s.close();
    }
    public static SocketChannel getSocketChannel(){
        return socketChannel;
    }
}