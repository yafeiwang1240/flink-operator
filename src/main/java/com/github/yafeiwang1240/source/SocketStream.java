package com.github.yafeiwang1240.source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SocketStream implements Runnable {

        private int port;

        public SocketStream(int port) {
            this.port = port;
        }

        public void run(){
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket socket = serverSocket.accept();
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(SocketStream.class.getClassLoader().getResourceAsStream("text.txt")))) {
                String str;
                while ((str = reader.readLine()) != null) {
                    writer.write(str);
                    writer.flush();
                    writer.newLine();
                    TimeUnit.MILLISECONDS.sleep(50);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }