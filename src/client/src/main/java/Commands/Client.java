package client.src.main.java.Commands;


import client.src.main.java.Commands.CommandManager;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {
    private static SocketChannel socketChannel = null;

    public static void main(String[] args) throws Exception {
        InetSocketAddress s=new InetSocketAddress("localhost",9997);
        String port="9998";
        socketChannel = SocketChannel.open();
        socketChannel.connect(s);
        socketChannel.configureBlocking(false);
        CommandManager.start();
        CommandManager.Scan();
    }
    public static SocketChannel getSocketChannel(){
        return socketChannel;
    }
}