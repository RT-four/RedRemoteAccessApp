package com.rtfour.RemoteRed;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("ssh -D 8181 phili@192.168.1.62 -D 8182 admin@10.129.0.27");
        Socket sc1 = new Socket("84.252.138.181", 8282);
        ServerSocket socket = new ServerSocket(8181);
        Socket sc = socket.accept();
        while (true) {
            new SendScreen(sc, robot, rectangle);
            new ReceiveEvents(sc, robot);
            //Start receiving screenshots
            new ReceiveScreen(in,cPanel);
            //Start sending events to the client
            new SendEvents(cSocket,cPanel,width,height);
        }
    }
}
