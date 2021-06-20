package com.rtfour.RemoteRed;

import javax.swing.*;
import java.net.Socket;

public class Start {

    static String port = "8181";

    public static void main(String args[]) {
        String ip = JOptionPane.showInputDialog("Please enter server ip");
        String password = JOptionPane.showInputDialog("Please enter server ip");
        new Start().initialize(ip, Integer.parseInt(port), password);
    }

    public void initialize(String ip, int port, String password) {
        try {

            Socket sc = new Socket(ip, port);
            System.out.println("Connecting to the Server");
            //Authenticate class is responsible for security purposes
            Authenticate frame1 = new Authenticate(sc, ip, password);

            frame1.setSize(300, 80);
            frame1.setLocation(500, 300);
            frame1.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



