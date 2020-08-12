package com.Model;

import java.io.IOException;
import java.net.Socket;

public class ObjectClient {

    private Socket socket;

    public ObjectClient() {

        try {
            socket = new Socket("127.0.0.1",3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket(){
        return socket;
    }
}
