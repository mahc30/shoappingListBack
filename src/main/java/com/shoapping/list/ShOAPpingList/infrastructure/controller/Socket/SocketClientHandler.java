package com.shoapping.list.ShOAPpingList.infrastructure.controller.Socket;

import com.shoapping.list.ShOAPpingList.application.dto.request.ProductRequest;
import com.shoapping.list.ShOAPpingList.application.handler.ProductHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
public class SocketClientHandler extends Thread {

    private Socket socket;
    private int id;
    protected BufferedReader inputStream;
    private PrintWriter outputStream;

    public SocketClientHandler(Socket socket, int id){
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run(){
        System.out.println("Thread " + id + " running");
        try{
            this.inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.outputStream = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage = inputStream.readLine();

            while(!clientMessage.equals("se fini")){
                write("ACK: " + clientMessage);
                System.out.println("Client " + this.id + ": " + clientMessage);
                clientMessage = inputStream.readLine();
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            outputStream.println("ADIOS");

            try {
                socket.close();
                System.out.println("SOCKET " + id + " CERRADO");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            interrupt();
        }
    }

    public boolean isConnected() {

        if (socket == null) {
            return false;
        }
        return socket.isConnected();
    }

    public boolean isClosed() {

        if (socket == null) {
            return true;
        }
        return socket.isClosed();
    }

    public void write(String msg) {
        if (outputStream == null) {
            System.out.println(" outputStream is null no se puede enviar");
            return;
        }
        System.out.println(" se envio " + msg);
        outputStream.println(msg);
    }
}
