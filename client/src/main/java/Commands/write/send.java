package Commands.write;

import Commands.Client;
import Serialized.SeriMessage;

import java.io.*;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class send {
    private static final SocketChannel socketChannel= Client.getSocketChannel();

    public static void send(Object m) throws IOException, ClassNotFoundException, InterruptedException {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(m);
            byte[] data = bos.toByteArray();
            Client.getSocketChannel().write(ByteBuffer.wrap(data));

            Thread.sleep(500);

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
            socketChannel.read(byteBuffer);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBuffer.array());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            //System.out.println(objectInputStream);
            SeriMessage o = (SeriMessage) objectInputStream.readObject();
            System.out.println(o.getMessage());
        } catch (ClassCastException | SocketException e){
            System.out.println("Сервера нет");
        }
    }
}
