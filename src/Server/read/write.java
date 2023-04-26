package Server.read;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.ParseException;
import java.util.Set;


public class write {
    //private final
    static Logger logger = LogManager.getLogger(write.class);
    static ServerSocketChannel s;
    static ServerSocketChannel sss;
    static SocketChannel client;
    static Socket c;
    static ByteBuffer byteBuffer;
    public static void s() throws IOException, ClassNotFoundException, ParseException {
        Selector selector=Selector.open();

        s=ServerSocketChannel.open();
        InetSocketAddress i =new InetSocketAddress(9997);
        s.bind(i);
        sss=s;
        s.configureBlocking(false);
        s.register(selector, SelectionKey.OP_ACCEPT);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!br.ready()) {
            selector.select(100);
            Set<SelectionKey> keys = selector.selectedKeys();
            for (var iter = keys.iterator(); iter.hasNext(); ) {
                SelectionKey key = iter.next(); iter.remove();
                if (key.isValid()) {
                    if (key.isAcceptable()) {
                        SocketChannel client = s.accept();
                        //System.out.println(client);
                        client.configureBlocking(false);

                        //System.out.println(client);
                        client.register(selector,SelectionKey.OP_READ);
                        logger.info("Новый клиент привет!!!");
                    }
                    if (key.isReadable()) {
                        //selector.selectNow();
                        if (attach(key)){
                            logger.info("Команда выполнена");
                        }
                        else {
                            logger.info("Пока клиент");
                            key.cancel();
                        }
                    }
                }
            }
        }
    }

    public static boolean attach(SelectionKey key){
        client =(SocketChannel) key.channel();

        try {
            byteBuffer = ByteBuffer.allocate(1024 * 1024);
            if (client.read(byteBuffer) <= 0) return false;
            //byteBuffer.flip();
            //c=client.socket();

            //ServerSocket ss =sss.socket();
            //Socket cl=ss.accept();
            //System.out.println(s.accept());
            //System.out.println(cl);
            //cl.configureBlocking(true);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBuffer.array());
            ObjectInputStream in = new ObjectInputStream(byteArrayInputStream);
            logger.info("Команда принята");
            //ObjectInputStream in = new ObjectInputStream(cl.getInputStream());
            Object object = in.readObject();
            new ObjectToSerialized(object);
            in.close();
            key.attach(object);
            return true;
        } catch (SocketException ignored){
        } catch (IOException | ClassNotFoundException | ParseException e) {
            logger.error("Ошибка RunTime");
        }
        return false;
    }
    public static Socket getc(){
        return c;
    }
    public static ByteBuffer getByteBuffer(){
        return byteBuffer;
    }
    public static SocketChannel getClient(){
        return client;
    }
}
