package com.duevornHarris;

/**
 * Created by duevornharris on 5/18/16.
 */
public interface Connection {

    String IP = "";
    String Port = "";
    String Protocol = "";

    String connect();

    String close();

    String getIP();
    void setIP(String IP);

    String getPort();
    void setPort(String port);

    String getProtocol();
    void setProtocol(String protocol);
}
