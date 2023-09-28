package com.shoapping.list.ShOAPpingList.infrastructure.controller.Socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class Server extends Thread {

    static int no_clients = 0;
    private static Server instance = null;

    public Server() {
        Thread sv = new Thread(this.serve());
        sv.start();
    }

    public static Server getInstance(){
        if(instance == null){
            instance = new Server();
        }
        return instance;
    }
    private Runnable serve(){
        ServerSocket server = null;
        try {
            server = new ServerSocket(666);
            System.out.println("SERVER SOCKET STARTED:");
            System.out.println("getInetAddress: " + server.getInetAddress());
            System.out.println("getLocalPort: " + server.getLocalPort());
            System.out.println("getLocalSocketAddress: " + server.getLocalSocketAddress());

            while(true){
                Socket socket = server.accept();
                SocketClientHandler handler = new SocketClientHandler(socket, ++no_clients);
                handler.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
