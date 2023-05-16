package Commands;


import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {
    private static SocketChannel socketChannel = null;

    public static void main(String[] args) throws Exception {
        try {
            InetSocketAddress s = new InetSocketAddress("localhost", 9997);
            String port = "9998";
            socketChannel = SocketChannel.open();
            socketChannel.connect(s);
            socketChannel.configureBlocking(false);
            CommandManager.start();
            CommandManager.Scan();
        }catch (ConnectException e){
            System.out.println("Сервера нет");
        }
    }
    public static SocketChannel getSocketChannel(){
        return socketChannel;
    }
}