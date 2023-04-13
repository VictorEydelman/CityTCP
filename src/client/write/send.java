package client.write;

import Common.SeriMessage;
import client.Client;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class send {
    private static SocketChannel socketChannel= Client.getSocketChannel();

    public static void send(Object m) throws IOException, ClassNotFoundException, InterruptedException {
        if (m instanceof Serializable){
            System.out.println(213);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        System.out.println(m);

        oos.writeObject(m);
        byte[] data = bos.toByteArray();
        System.out.println(socketChannel);
        System.out.println(Client.getSocketChannel());
        Client.getSocketChannel().write(ByteBuffer.wrap(data));

        Thread.sleep(1000);


        ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
        socketChannel.read(byteBuffer);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBuffer.array());
        System.out.println();
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        SeriMessage o = (SeriMessage) objectInputStream.readObject();
        System.out.println(o.getMessage());


    }
}
