package com.duevornHarris;

/**
 * Created by duevornharris on 5/18/16.
 */
public class InnerClasses {
    public static void main(String[] args) {

        ConnectionManager connectionManager = new ConnectionManager();

        Connection connection1 = connectionManager.makeConnection("196.240.192.128", "HTTP");
        Connection connection2 = connectionManager.makeConnection("196.248.190.192", "PPP");
        Connection connection3 = connectionManager.makeConnection("196.172..128.252", "TCP");

        connection1.close();
        connection2.close();
        connection3.close();



    }
}