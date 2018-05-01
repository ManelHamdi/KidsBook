package com.example.manel.KidsBook.webServiceConf;

/**
 * Created by manel on 10/04/2018.
 */

public class ServerAdress {
    public static String getserverAdr(){
        String ServerAdr = "http://192.168.8.100";
       // String ServerAdr = "http://127.16.7.82";
        int port = 20320;
        return ServerAdr + ":" + port;
    }
}
