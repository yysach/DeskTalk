package com.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {

    private Socket socket=null;
    private ServerSocket serverSocket=null;

    public ObjectServer() {
        try {
            serverSocket = new ServerSocket(3000);
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Socket getSocket() {
        return socket;
    }
}
