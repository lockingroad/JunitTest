package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClient {
    private BufferedReader socketReader;

    public static void main(String[] args) {
        SocketClient socketClient=new SocketClient();
        socketClient.start();
    }

    private Socket socket;
    private BufferedWriter bw;
    private BufferedReader br;

    private void start() {
        // TODO Auto-generated method stub

        try {
            socket=new Socket("192.168.1.120",9799);
            bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            socketReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            listenServer(socketReader);
            br=new BufferedReader(new InputStreamReader(System.in));
            String brContent;
            while(!(brContent=br.readLine()).equals("bye")){
                System.out.println("客户端输入"+brContent);
                bw.write(brContent+"\n");
                bw.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                bw.close();
                br.close();
                socketReader.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    private void listenServer(final BufferedReader br) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String content;
                try {
                    while ((content=br.readLine())!=null){
                        System.out.println("监听中"+content);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
