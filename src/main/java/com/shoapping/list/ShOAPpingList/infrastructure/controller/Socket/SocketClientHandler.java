package com.shoapping.list.ShOAPpingList.infrastructure.controller.Socket;

import lombok.extern.java.Log;
import net.bytebuddy.implementation.bytecode.Throw;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketClientHandler extends Thread {

    private Socket socket;
    private int id;
    private BufferedReader inputStream;
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

            String clientMessage = "";

            while(!clientMessage.equals("se fini")){
                clientMessage = inputStream.readLine();
                System.out.println("Client " + this.id + ": " + clientMessage);
            }

            System.out.println("CLIENT HANDLER CLOSE");
            socket.close();
        }catch (Exception e){

        }
    }
}
