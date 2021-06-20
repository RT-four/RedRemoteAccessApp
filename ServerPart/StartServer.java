package com.rtfour.RemoteRed;

import com.rtfour.RemoteRed.SetPassword;

public class StartServer {
    public static void main(String[] args) {

    }
    public void start(String password){
        try{
            Runtime.getRuntime().exec("ssh -D 8181 phili@192.168.1.62");

        }catch(Exception e){
        }
        new SetPassword(password);
    }
}
