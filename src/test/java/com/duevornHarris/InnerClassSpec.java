package com.duevornHarris;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by duevornharris on 5/18/16.
 */
public class InnerClassSpec {

    @Test
    public void makeConnectionTestObject(){
        ConnectionManager connectionManager = new ConnectionManager();
        Assert.assertNotNull("The method does not return an Object", connectionManager.makeConnection("127.0.0.1",
                "PPP"));
    }

    @Test
    public void makeConnectionTestNull(){
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.numberOfConnectionsLimit = 0;
        Assert.assertNull("The method returns an Object ", connectionManager.makeConnection("123", "PPP"));

    }

    @Test
    public void closeConnectionTest(){
        ConnectionManager connectionManager = new ConnectionManager();
        //connectionManager.makeConnection("192.168.186.252", "TCP");
        Connection connection = connectionManager.makeConnection("192.168.186.252", "TCP");
        String expectedString = "A connection has been closed";
        Assert.assertEquals("Connection was not closed ", expectedString, connection.close());
    }

    @Test
    public void connectConnectionTest(){
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.makeConnection("192.168.186.252", "TCP");
        String expectedResult = "A connection has been made.";
        String actualResult = connection.connect();
        Assert.assertEquals("Connection was not opened ", expectedResult, actualResult);

    }

}
