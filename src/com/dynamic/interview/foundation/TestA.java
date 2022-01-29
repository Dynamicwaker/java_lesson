package com.dynamic.interview.foundation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: xinghj0308@gmail.com
 * @create: 2021/12/20
 * @description:
 */
public class TestA {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8099);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        while((request = in.readLine()) != null) {
            if("Done".equals(request)) {
                break;
            }
        }
    }
}
