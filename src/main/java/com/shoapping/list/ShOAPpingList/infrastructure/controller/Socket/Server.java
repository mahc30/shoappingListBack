package com.shoapping.list.ShOAPpingList.infrastructure.controller.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {


    int no_clients = 0;

    public Server() {
        Thread sv = new Thread(this.serve());
        sv.start();
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
                System.out.println("Client " + no_clients);
                handler.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
