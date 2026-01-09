package com.hamitmizrak._08_week_socket.server;

import com.hamitmizrak._08_week_socket.PORT_HOST_OTHER;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServerMain {

    // PSVM
    public static void main(String[] args) throws IOException {
        int port = PORT_HOST_OTHER.PORT;
        if (args.length >= 1) {
            port = Integer.parseInt(args[0]);
        }

        ChatRoom room= new ChatRoom();

        // Aynı anda en fazla 32 cleint aktif olabilir(WN: Worker Number)
        // Daha fazla bağlantı olursa
        ExecutorService pool= Executors.newFixedThreadPool(32);

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Chat Server port dinliyor: "+port);

            while(true){
                Socket socket =serverSocket.accept();
                pool.submit(new ClientSession(socket,room));
            }
        }finally {
            pool.shutdown();
        }
    } //end psvm

} //end ChatServerMain
