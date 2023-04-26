package client.write;

import Common.Serialized.SeriMessage;
import client.Client;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class send {
    private static final SocketChannel socketChannel= Client.getSocketChannel();

    public static void send(Object m) throws IOException, ClassNotFoundException, InterruptedException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(m);
        byte[] data = bos.toByteArray();
        Client.getSocketChannel().write(ByteBuffer.wrap(data));

        Thread.sleep(500);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
        socketChannel.read(byteBuffer);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBuffer.array());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        SeriMessage o = (SeriMessage) objectInputStream.readObject();
        System.out.println(o.getMessage());
    }
}
